package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

import java.util.List;
import java.util.stream.Collectors;

public class AiPlayer extends Player {

    private final int LOOKAHEAD = 4;

    private Board3D board3D;
    private EvaluationFunction evaluationFunction;

    public AiPlayer(Board3D board3D, Symbol symbol) {
        super(symbol);
        this.board3D = board3D;
        this.evaluationFunction = new EvaluationFunction(WinningLinesPositions.getInstance());
    }

    @Override
    public PlayerMove makeMove() {
        return miniMax();
    }

    private PlayerMove miniMax() {
        if (board3D.getFreePositionList().isEmpty())
            throw new RuntimeException("El tablero está lleno, no se puede hacer movimiento");

        SearchNode searchNode = new SearchNode(board3D, new PlayerMove(-1,0));
        return miniMax(searchNode, LOOKAHEAD, Integer.MIN_VALUE, Integer.MAX_VALUE, true).getPlayerMove();
    }

    private SearchNode miniMax(SearchNode currentState, int lookAhead, int alpha, int beta, boolean isMaximizing) {

        List<Integer> freePositionList = currentState.getBoard3D().getFreePositionList();

        if (lookAhead == 0 || freePositionList.isEmpty() || currentState.isTerminalNode()) {
            int points = evaluationFunction.evaluate(currentState.getBoard3D(), symbol, enemySymbol);
            currentState.getPlayerMove().setPoints(points);
            return currentState;
        }

        Symbol symbolToPut = isMaximizing ? symbol : enemySymbol;

        List<SearchNode> childStates = freePositionList.stream().map(position -> {
                    Board3D newBoard = Board3D.createBoardWithMove(currentState.getBoard3D(), position, symbolToPut);
                    PlayerMove playerMove = new PlayerMove(position, 0);
                    return new SearchNode(newBoard, playerMove);
                }
        ).collect(Collectors.toList());

        if (isMaximizing) {
            SearchNode maxState = new SearchNode(null, new PlayerMove(-1, Integer.MIN_VALUE));
            for (SearchNode childState : childStates) {
                int value = miniMax(childState, lookAhead - 1, alpha, beta, false).getPlayerMove().getPoints();
                if (value > maxState.getPlayerMove().getPoints()) {
                    childState.getPlayerMove().setPoints(value);
                    maxState = childState;
                }
                // Poda
                alpha = Math.max(alpha, value);
                if (alpha >= beta)
                    break;
            }
            return maxState;
        } else {
            SearchNode minState = new SearchNode(null, new PlayerMove(-1, Integer.MAX_VALUE));
            for (SearchNode childState : childStates) {
                int value = miniMax(childState, lookAhead -1, alpha, beta, true).getPlayerMove().getPoints();
                if (value < minState.getPlayerMove().getPoints()) {
                    childState.getPlayerMove().setPoints(value);
                    minState = childState;
                }
                // Poda
                beta = Math.min(beta, value);
                if (alpha >= beta)
                    break;
            }
            return minState;
        }

    }

}
