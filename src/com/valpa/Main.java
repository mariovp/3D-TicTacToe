package com.valpa;

public class Main {

    public static void main(String[] args) {

        //var board3d = new Board3D();
        //var winningLinesPositions = new WinningLinesPositions();

        //System.out.println(winningLinesPositions.toString());

        /*var evaluationFunction = new EvaluationFunction(winningLinesPositions);

        int points = evaluationFunction.evaluate(board3d);

        System.out.println("Evaluation = "+points);*/

        //System.out.println(cubeIndex.getCoordinates3DFromPosition(38));

        var board3D = new Board3D();
        System.out.println(board3D);

        var aiPlayer = new AiPlayer(board3D, Symbol.CROSS);
        var aiPlayer2 = new AiPlayer(board3D, Symbol.CIRCLE);

        for (int i = 0; i < 4; i++) {
            var move1 = aiPlayer.makeMove();
            System.out.println(move1);
            board3D.setCell(move1.getPosition(), Symbol.CROSS);
            System.out.println(board3D);

            var move2 = aiPlayer2.makeMove();
            System.out.println(move2);
            board3D.setCell(move2.getPosition(), Symbol.CIRCLE);
            System.out.println(board3D);
        }

        /*var move1 = aiPlayer.makeMove();
        System.out.println(move1);
        board3D.setCell(move1.getPosition(), Symbol.CROSS);
        System.out.println(board3D);

        var move2 = aiPlayer.makeMove();
        System.out.println(move2);
        board3D.setCell(move2.getPosition(), Symbol.CROSS);
        System.out.println(board3D);*/

    }

}
