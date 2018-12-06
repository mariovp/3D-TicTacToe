package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

public class EvaluationFunction {

    private WinningLinesPositions winningLinesPositions;

    public EvaluationFunction(WinningLinesPositions winningLinesPositions) {
        this.winningLinesPositions = winningLinesPositions;
    }

    public int evaluate(Board3D board3D, Symbol aiPlayerSymbol, Symbol enemySymbol) {

        int points = 0;

        for (int[] winLine : winningLinesPositions.getWinningLinesPositionArray()) {

            int aiCount = 0;
            int enemyCount = 0;

            for (int pos : winLine) {
                if (board3D.getCubeCell(pos) == aiPlayerSymbol)
                    aiCount++;
                else if (board3D.getCubeCell(pos) == enemySymbol)
                    enemyCount++;
            }

            if (aiCount == 4)
                return Integer.MAX_VALUE;
            else if (enemyCount == 4)
                return Integer.MIN_VALUE;

            boolean hasOnePlayerOnly = (aiCount > 0 && enemyCount == 0) || (enemyCount > 0 && aiCount == 0);

            if (hasOnePlayerOnly) {
                if (aiCount > 0)
                    points += Math.pow(110, aiCount-1);
                else
                    points -= Math.pow(100, enemyCount-1);
            }

        }

        return points;
    }

}
