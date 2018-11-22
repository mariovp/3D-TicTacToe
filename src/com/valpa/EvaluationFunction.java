package com.valpa;

public class EvaluationFunction {

    private WinningLinesPositions winningLinesPositions;

    public EvaluationFunction(WinningLinesPositions winningLinesPositions) {
        this.winningLinesPositions = winningLinesPositions;
    }

    public int evaluate(Board3D board3D, Symbol aiPlayerSymbol, Symbol enemySymbol) {
        int aiPoints = evaluate(board3D, aiPlayerSymbol);
        int enemyPoints = evaluate(board3D, enemySymbol);

        return aiPoints-enemyPoints;
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

            if (lineCoincidences > points)
                points = lineCoincidences;
        }
        return points;
    }

}
