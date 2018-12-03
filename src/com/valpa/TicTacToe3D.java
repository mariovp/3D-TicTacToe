package com.valpa;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.player.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe3D {

    private Scanner scanner = new Scanner(System.in);

    private Symbol askAiSymbol() {

        while (true) {
            System.out.println("¿Cuál símbolo va a usar la IA? Escoge \"x\" u \"o\" ");
            String symbolResponse = scanner.next().trim();

            if (symbolResponse.matches("x"))
                return Symbol.CROSS;
            else if (symbolResponse.matches("o"))
                return Symbol.CIRCLE;
            else
                System.out.println("Respuesta inválida");
        }

    }

    private boolean isAiFirst() {

        while (true) {
            System.out.println("¿Dar primer turno a la IA? ");
            String userInput = scanner.next().trim();

            if (userInput.matches("Si|si|yes|1"))
                return true;
            else if (userInput.matches("No|no|0"))
               return false;
            else
                System.out.println("Respuesta inválida");
        }

    }

    public void startGame() {
        var board3D = new Board3D();

        Symbol aiSymbol = askAiSymbol();
        boolean isAiFirst = isAiFirst();

        var aiPlayer = new AiPlayer(board3D, aiSymbol, PlayerStrategy.DEFENSE);
        var enemyPlayer = new HumanPlayer(aiPlayer.getEnemySymbol());

        List<Player> playerList = new ArrayList<>();

        playerList.add(aiPlayer);
        playerList.add(enemyPlayer);

        if (!isAiFirst)
            Collections.reverse(playerList);

        System.out.println("Comienza el juego");

        System.out.println(board3D);
        gameLoop:
        while (!board3D.getFreePositionList().isEmpty()) {

            for (Player player : playerList) {
                PlayerMove playerMove = player.makeMove();
                board3D.setCell(playerMove.getPosition(), player.getSymbol());

                System.out.println("Movimiento: "+playerMove);
                System.out.println(board3D);

                if (board3D.checkWin(player.getSymbol())) {
                    System.out.println("El jugador con el simbolo " + player.getSymbol() + " ganó");
                    break gameLoop;
                }
            }
        }

        if (board3D.getFreePositionList().isEmpty())
            System.out.println("Se acabaron los espacios del tablero");

        System.out.println("Fin del juego");

    }

}
