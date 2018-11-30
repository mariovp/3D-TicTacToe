package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AiPlayer extends Player {

    private Board3D board3D;
    private EvaluationFunction evaluationFunction;

    public AiPlayer(Board3D board3D, Symbol symbol, PlayerStrategy playerStrategy) {
        super(symbol);
        this.board3D = board3D;
        this.evaluationFunction = new EvaluationFunction(WinningLinesPositions.getInstance(), playerStrategy);
    }

    @Override
    public PlayerMove makeMove() {
        return negaMax();
    }

    private PlayerMove negaMax() {
        if (board3D.getFreePositionList().isEmpty())
            throw new RuntimeException("El tablero está lleno, no se puede hacer movimiento");
        return negaMax(board3D, 0, 2, 1);
    }

    private PlayerMove negaMax(Board3D currentBoard, int movePosition, int lookAhead, int pov) {

        List<Integer> freePositionList = currentBoard.getFreePositionList();

        if (lookAhead == 0 || freePositionList.isEmpty()) {
            Board3D newBoard = Board3D.createBoardWithMove(currentBoard, movePosition, enemySymbol);
            int points = pov * evaluationFunction.evaluate(newBoard, symbol, enemySymbol);
            return new PlayerMove(movePosition, points);
        }

        List<PlayerMove> playerMoveList = freePositionList.stream().map(position ->
                negaMax(currentBoard, position, lookAhead - 1, -pov)
        ).collect(Collectors.toList());

        return playerMoveList.stream().max(Comparator.comparing(pm -> pm.getPoints() * pov)).get();
    }

}
