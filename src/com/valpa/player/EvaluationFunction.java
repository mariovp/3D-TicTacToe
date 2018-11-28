package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluationFunction {

    private WinningLinesPositions winningLinesPositions;

    public EvaluationFunction(WinningLinesPositions winningLinesPositions) {
        this.winningLinesPositions = winningLinesPositions;
    }

    public int evaluate(Board3D board3D, Symbol aiPlayerSymbol, Symbol enemySymbol) {

        int points = 0;

        for (int[] winLine : winningLinesPositions.getWinningLinesPositionArray()) {

            List<Integer> playerMovePositionsInLine = Arrays.stream(winLine).filter(pos -> {
                Symbol symbol = board3D.getCubeCell(pos);
                return symbol == aiPlayerSymbol || symbol == enemySymbol;
            }).boxed().collect(Collectors.toList());

            if (playerMovePositionsInLine.size() > 0) {
                int aiPlayerSymbolCount = (int) playerMovePositionsInLine.stream().filter(pos -> board3D.getCubeCell(pos) == aiPlayerSymbol).count();
                int enemySymbolCount = (int) playerMovePositionsInLine.stream().filter(pos -> board3D.getCubeCell(pos) == enemySymbol).count();

                if (enemySymbolCount == 0) {
                    points -= Math.pow(10, aiPlayerSymbolCount);
                } else if (aiPlayerSymbolCount == 0) {
                    points += Math.pow(11, enemySymbolCount);
                }

            }
        }

        return points;
    }

    private int evaluate(Board3D board3D, Symbol playerSymbol) {
        int points = 0;
        for (int[] line : winningLinesPositions.getWinningLinesPositionArray()) {

            int lineCoincidences = 0;
            for (int pos : line) {

                Symbol symbol = board3D.getCubeCell(pos);
                if (symbol == playerSymbol)
                    lineCoincidences++;
            }

            switch (lineCoincidences) {
                case 1: points +=1;
                    break;
                case 2: points +=10;
                    break;
                case 3: points += 100;
                    break;
                case 4: points += 1000;
                    break;
            }
        }
        return points;
    }

}
