package com.valpa;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;
import com.valpa.player.*;

public class Main {

    public static void main(String[] args) {

        var board3D = new Board3D();
        System.out.println(board3D);

        /*Symbol aiSymbol = Symbol.CROSS;
        Symbol enemySymbol = Symbol.CIRCLE;

        board3D.setCell(0,aiSymbol);
        board3D.setCell(4, enemySymbol);
        board3D.setCell(21, aiSymbol);

        EvaluationFunction evaluationFunction = new EvaluationFunction(WinningLinesPositions.getInstance());

        int points = evaluationFunction.evaluate(board3D, aiSymbol, enemySymbol);

        System.out.println(board3D);

        System.out.println("Puntos = "+points);*/

        var aiPlayer = new AiPlayer(board3D, Symbol.CROSS, PlayerStrategy.ATTACK);
        var aiPlayer2 = new HumanPlayer(Symbol.CIRCLE);

        for (int i = 0; i < 32; i++) {
            var move1 = aiPlayer.makeMove();
            System.out.println(move1);
            board3D.setCell(move1.getPosition(), Symbol.CROSS);
            System.out.println(board3D);
            System.out.println("Player1 is win = "+board3D.checkWin(Symbol.CROSS));

            var move2 = aiPlayer2.makeMove();
            System.out.println(move2);
            board3D.setCell(move2.getPosition(), Symbol.CIRCLE);
            System.out.println(board3D);
            System.out.println("Player2 is win = "+board3D.checkWin(Symbol.CIRCLE));
        }

        System.out.println("Fin de los turnos");

    }

}
