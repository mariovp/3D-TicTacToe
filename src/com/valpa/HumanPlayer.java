package com.valpa;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private static final String MOVE_REGEX = "^[0-9]+,[0-9]+,[0-9]+$";

    private Scanner sc = new Scanner(System.in);

    public HumanPlayer(Symbol symbol) {
        super(symbol);
    }

    @Override
    public PlayerMove makeMove() {
        return askPlayerMove();
    }

    private PlayerMove askPlayerMove() {

        PlayerMove playerMove = null;

        boolean hasValidResponse = false;
        do {

            System.out.println("Ingrese su próximo movimiento en formato z,y,x: ");
            String response = sc.next();

            if (response.matches(MOVE_REGEX)) {
                String[] splitResponse = response.split(",");

                int z = Integer.valueOf(splitResponse[0]);
                int y = Integer.valueOf(splitResponse[1]);
                int x = Integer.valueOf(splitResponse[2]);

                int position = (z * 16) + (y * 4) + x;

                playerMove = new PlayerMove(position, 0);
                hasValidResponse = true;
            }

        } while (!hasValidResponse);

        return playerMove;
    }

}
