package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AiPlayer2 extends Player {

    private Board3D board3D;
    private EvaluationFunction2 evaluationFunction;

    public AiPlayer2(Board3D board3D, Symbol symbol) {
        super(symbol);
        this.board3D = board3D;
        this.evaluationFunction = new EvaluationFunction2(WinningLinesPositions.getInstance());
    }

    @Override
    public PlayerMove makeMove() {
        return miniMax();
    }

    private PlayerMove miniMax() {
        int lookAhead = 2;
        // Funciona con lookahead impar y enemyTurn true, o lookahead par y enemyTurn false
        return max(board3D,0,lookAhead);
    }

    private PlayerMove max(Board3D currentBoard, int movePosition, int lookAhead) {
        if (lookAhead == 0) {
            Board3D newBoard = Board3D.createBoardWithMove(currentBoard, movePosition, symbol);
            int points = evaluationFunction.evaluate(newBoard, symbol, enemySymbol);
            return new PlayerMove(movePosition, points);
        }

        List<Integer> freePositionList = currentBoard.getFreePositionList();

        List<PlayerMove> playerMoveList = freePositionList.stream().map(position -> {
            return min(currentBoard, position, lookAhead-1);
        }).collect(Collectors.toList());

        return playerMoveList.stream()
                .max(Comparator.comparingInt(PlayerMove::getPoints)).get();
    }

    private PlayerMove min(Board3D currentBoard, int movePosition, int lookAhead) {
        if (lookAhead == 0) {
            Board3D newBoard = Board3D.createBoardWithMove(currentBoard, movePosition, enemySymbol);
            int points = evaluationFunction.evaluate(newBoard, symbol, enemySymbol);
            return new PlayerMove(movePosition, points);
        }

        List<Integer> freePositionList = currentBoard.getFreePositionList();

        List<PlayerMove> playerMoveList = freePositionList.stream().map(position -> {
            return max(currentBoard, position, lookAhead-1);
        }).collect(Collectors.toList());

        return playerMoveList.stream()
                .min(Comparator.comparingInt(PlayerMove::getPoints)).get();
    }

}
