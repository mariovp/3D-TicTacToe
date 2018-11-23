package com.valpa;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.player.AiPlayer;
import com.valpa.player.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        var board3D = new Board3D();
        System.out.println(board3D);

        var aiPlayer = new AiPlayer(board3D, Symbol.CROSS);
        var aiPlayer2 = new HumanPlayer(Symbol.CIRCLE);

        for (int i = 0; i < 20; i++) {
            var move1 = aiPlayer.makeMove();
            System.out.println(move1);
            board3D.setCell(move1.getPosition(), Symbol.CROSS);
            System.out.println(board3D);

            var move2 = aiPlayer2.makeMove();
            System.out.println(move2);
            board3D.setCell(move2.getPosition(), Symbol.CIRCLE);
            System.out.println(board3D);
        }

        System.out.println("Fin de los turnos");

    }

}
