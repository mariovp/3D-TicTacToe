package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

import java.util.Arrays;

public class EvaluationFunction {

    private WinningLinesPositions winningLinesPositions;

    public EvaluationFunction(WinningLinesPositions winningLinesPositions) {
        this.winningLinesPositions = winningLinesPositions;
    }

    public int evaluate(Board3D board3D, Symbol aiPlayerSymbol, Symbol enemySymbol) {

        int points = 0;

        for (int[] winLine : winningLinesPositions.getWinningLinesPositionArray()) {

            int aiPlayerSymbolCount = (int) Arrays.stream(winLine).filter(position -> board3D.getCubeCell(position) == aiPlayerSymbol).count();
            int enemySymbolCount = (int) Arrays.stream(winLine).filter(position -> board3D.getCubeCell(position) == enemySymbol).count();

            boolean hasAiPlayerPointsOnly = aiPlayerSymbolCount > 0 && enemySymbolCount == 0;
            boolean hasEnemyPointsOnly = enemySymbolCount > 0 && aiPlayerSymbolCount == 0;

            if (hasAiPlayerPointsOnly)
                points -= Math.pow(10, aiPlayerSymbolCount);
            else if (hasEnemyPointsOnly)
                points += Math.pow(11, enemySymbolCount);
        }

        return points;
    }

}
