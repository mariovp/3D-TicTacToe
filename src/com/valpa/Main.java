package com.valpa;

public class Main {

    public static void main(String[] args) {

        TicTacToe3D ticTacToe3D = new TicTacToe3D();

        ticTacToe3D.startGame();

        /*var baseBoard = new Board3D();
        var evaluationFunction = new EvaluationFunction(WinningLinesPositions.getInstance());

        baseBoard.setCell(0, Symbol.CIRCLE);
        baseBoard.setCell(4, Symbol.CIRCLE);
        baseBoard.setCell(12, Symbol.CIRCLE);

        baseBoard.setCell(41, Symbol.CROSS);

        baseBoard.setCell(48, Symbol.CIRCLE);
        baseBoard.setCell(60, Symbol.CROSS);
        baseBoard.setCell(61, Symbol.CROSS);
        baseBoard.setCell(63, Symbol.CROSS);

        System.out.println("Base board = "+evaluationFunction.evaluate(baseBoard, Symbol.CROSS, Symbol.CIRCLE));

        var winBoard = Board3D.createBoardWithMove(baseBoard, 62, Symbol.CROSS);
        System.out.println("Win board = "+evaluationFunction.evaluate(winBoard, Symbol.CROSS, Symbol.CIRCLE));

        var blockBoard = Board3D.createBoardWithMove(baseBoard, 8, Symbol.CROSS);
        System.out.println("Block board = "+evaluationFunction.evaluate(blockBoard, Symbol.CROSS, Symbol.CIRCLE));

        var afterWin = Board3D.createBoardWithMove(winBoard, 8, Symbol.CIRCLE);
        System.out.println("After win = "+evaluationFunction.evaluate(afterWin, Symbol.CROSS, Symbol.CIRCLE));*/

    }

}
