package com.valpa;

public class Main {

    public static void main(String[] args) {

        var board3d = new Board3D();
        var winningLinesPositions = new WinningLinesPositions();

        //System.out.println(winningLinesPositions.toString());

        var evaluationFunction = new EvaluationFunction(winningLinesPositions);

        int points = evaluationFunction.evaluate(board3d);

        System.out.println("Evaluation = "+points);

        //System.out.println(cubeIndex.getCoordinates3DFromPosition(38));
    }

}
