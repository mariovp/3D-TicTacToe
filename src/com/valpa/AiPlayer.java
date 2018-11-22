package com.valpa;

import java.util.Comparator;
import java.util.List;
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
        int lookAhead = 3;
        return miniMax(board3D, 0, lookAhead,false);
    }

    private PlayerMove miniMax(Board3D currentBoard, int movePosition, int lookAhead, boolean isEnemyTurn) {

        if (lookAhead == 0) {
            Symbol moveSymbol = isEnemyTurn ? enemySymbol : symbol;
            Board3D newBoard = Board3D.createBoardWithMove(currentBoard, movePosition, moveSymbol);
            int points = evaluationFunction.evaluate(newBoard, moveSymbol);
            return new PlayerMove(movePosition, points);
        }

        List<Integer> freePositionList = currentBoard.getFreePositionList();

        List<PlayerMove> playerMoveList = freePositionList.stream().map(position -> {
            return miniMax(currentBoard, position, lookAhead-1, !isEnemyTurn);
        }).collect(Collectors.toList());

        if (isEnemyTurn) {
            return playerMoveList.stream()
                    .min(Comparator.comparingInt(PlayerMove::getPoints)).get();
        } else {
            return playerMoveList.stream()
                    .max(Comparator.comparingInt(PlayerMove::getPoints)).get();
        }
    }

}
