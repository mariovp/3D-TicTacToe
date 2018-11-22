package com.valpa;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AiPlayer implements Player {

    private Board3D board3D;
    private Symbol symbol;
    private Symbol enemySymbol;
    private WinningLinesPositions winningLinesPositions;
    private EvaluationFunction evaluationFunction;

    public AiPlayer(Board3D board3D, Symbol symbol) {
        this.board3D = board3D;
        this.symbol = symbol;
        this.enemySymbol = this.symbol == Symbol.CROSS ? Symbol.CIRCLE : Symbol.CROSS;
        this.winningLinesPositions = new WinningLinesPositions();
        this.evaluationFunction = new EvaluationFunction(winningLinesPositions);
    }

    @Override
    public PlayerMove makeMove() {
        return miniMax();
    }

    private PlayerMove miniMax() {
        int lookAhead = 2;
        return max(board3D, 0, lookAhead);
    }

    private PlayerMove mini(Board3D currentBoard, int movePosition, int lookAhead) {

        if (lookAhead == 0) {
            Board3D newBoard = Board3D.createBoardWithMove(board3D, movePosition, enemySymbol);
            int points = evaluationFunction.evaluate(newBoard, symbol);
            return new PlayerMove(enemySymbol, movePosition, points);
        }

        List<Integer> freePositionList = currentBoard.getFreePositionList();

        List<PlayerMove> playerMoveList = freePositionList.stream().map(position -> {
            return max(currentBoard, position, lookAhead - 1);
        }).collect(Collectors.toList());

        Optional<PlayerMove> minMove = playerMoveList.stream()
                .min(Comparator.comparingInt(PlayerMove::getPoints));

        return minMove.get();
    }

    private PlayerMove max(Board3D currentBoard, int movePosition, int lookAhead) {

        if (lookAhead == 0) {
            Board3D newBoard = Board3D.createBoardWithMove(board3D, movePosition, symbol);
            int points = evaluationFunction.evaluate(newBoard, symbol);
            return new PlayerMove(symbol, movePosition, points);
        }

        List<Integer> freePositionList = currentBoard.getFreePositionList();

        List<PlayerMove> playerMoveList = freePositionList.stream().map(position -> {
            return mini(currentBoard, position, lookAhead - 1);
        }).collect(Collectors.toList());

        PlayerMove maxMove = playerMoveList.stream()
                .max(Comparator.comparingInt(PlayerMove::getPoints)).get();

        return maxMove;
    }

}
