package com.valpa;

public class EvaluationFunction {

    private CubeIndex cubeIndex;
    private WinningLinesPositions winningLinesPositions;

    public EvaluationFunction(CubeIndex cubeIndex, WinningLinesPositions winningLinesPositions) {
        this.cubeIndex = cubeIndex;
        this.winningLinesPositions = winningLinesPositions;
    }

    public int evaluate(Board3D board3D) {
        int points = 0;
        for (int[] line : winningLinesPositions.getWinningLinesPositionArray()) {
            for (int pos : line) {
                Coordinates3D coordinates3D = cubeIndex.getCoordinates3DFromPosition(pos);
                CubeCell cubeCell = board3D.getCubeCell(coordinates3D);
                if (cubeCell == CubeCell.CROSS)
                    points++;
            }
        }
        return points;
    }

}
