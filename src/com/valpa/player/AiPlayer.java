package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AiPlayer extends Player {

    private final int LOOKAHEAD = 1;

    private Board3D board3D;
    private EvaluationFunction evaluationFunction;

    public AiPlayer(Board3D board3D, Symbol symbol) {
        super(symbol);
        this.board3D = board3D;
        this.evaluationFunction = new EvaluationFunction(WinningLinesPositions.getInstance());
    }

    @Override
    public PlayerMove makeMove() {
        return negaMax();
    }

    private PlayerMove negaMax() {
        if (board3D.getFreePositionList().isEmpty())
            throw new RuntimeException("El tablero está lleno, no se puede hacer movimiento");

        SearchNode searchNode = new SearchNode(board3D, new PlayerMove(0,0));
        return negaMax(searchNode, LOOKAHEAD, 1).getPlayerMove();
    }

    private SearchNode negaMax(SearchNode currentState, int lookAhead, int pov) {

        List<Integer> freePositionList = currentState.getBoard3D().getFreePositionList();

        if (lookAhead == 0 || freePositionList.isEmpty()) {
            Symbol currentPlayerSymbol = pov == 1 ? symbol : enemySymbol;
            Symbol currentEnemySymbol = pov == -1 ? symbol : enemySymbol;
            int points = pov * evaluationFunction.evaluate(currentState.getBoard3D(), currentPlayerSymbol, currentEnemySymbol);
            currentState.getPlayerMove().setPoints(points);
            return currentState;
        }

        Symbol symbolToPut = pov == 1 ? symbol : enemySymbol;

        List<SearchNode> childStates = freePositionList.stream().map(position -> {
                    Board3D newBoard = Board3D.createBoardWithMove(currentState.getBoard3D(), position, symbolToPut);
                    PlayerMove playerMove = new PlayerMove(position, 0);
                    return new SearchNode(newBoard, playerMove);
                }
        ).collect(Collectors.toList());

        // Validación de movimiento ganador en profundidad inicial (funciona para LOOKAHEAD mayor a 1)
        /*Optional<SearchNode> winningMove = Optional.empty();

        if (freePositionList.size() < 57 && lookAhead == LOOKAHEAD) {
            childStates.forEach(searchNode -> {
                int points = evaluationFunction.evaluate(searchNode.getBoard3D(), symbol, enemySymbol);
                searchNode.getPlayerMove().setPoints(points);
            });
            winningMove = childStates.stream().filter(searchNode -> searchNode.getPlayerMove().getPoints() == Integer.MAX_VALUE).findFirst();
        }*/

        return childStates.stream()
                .map(searchNode -> negaMax(searchNode, lookAhead - 1, -pov))
                .max(Comparator.comparing(sn -> sn.getPlayerMove().getPoints() * pov)).get();

    }

}
