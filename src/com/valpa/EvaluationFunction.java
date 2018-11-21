package com.valpa;

public class EvaluationFunction {

    private WinningLinesPositions winningLinesPositions;

    public EvaluationFunction(WinningLinesPositions winningLinesPositions) {
        this.winningLinesPositions = winningLinesPositions;
    }

    public int evaluate(Board3D board3D) {

        int points = 0;
        for (int[] line : winningLinesPositions.getWinningLinesPositionArray()) {

            int lineCoincidences = 0;
            for (int pos : line) {

                Cell cell = board3D.getCubeCell(pos);
                if (cell == Cell.CROSS)
                    lineCoincidences++;
            }

            if (lineCoincidences > points)
                points = lineCoincidences;
        }
        return points;
    }

}
