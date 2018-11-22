package com.valpa;

public class EvaluationFunction {

    private WinningLinesPositions winningLinesPositions;

    public EvaluationFunction(WinningLinesPositions winningLinesPositions) {
        this.winningLinesPositions = winningLinesPositions;
    }

    public int evaluate(Board3D board3D, Symbol aiPlayerSymbol) {

        int points = 0;
        for (int[] line : winningLinesPositions.getWinningLinesPositionArray()) {

            int lineCoincidences = 0;
            for (int pos : line) {

                Symbol symbol = board3D.getCubeCell(pos);
                if (symbol == aiPlayerSymbol)
                    lineCoincidences++;
            }

            if (lineCoincidences > points)
                points = lineCoincidences;
        }
        return points;
    }

}
