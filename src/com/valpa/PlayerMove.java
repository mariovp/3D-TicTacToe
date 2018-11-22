package com.valpa;

public class PlayerMove {

    private Symbol symbol;
    private int position;
    private int points;

    public PlayerMove(Symbol symbol, int position, int points) {
        this.symbol = symbol;
        this.position = position;
        this.points = points;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "PlayerMove{" +
                "symbol=" + symbol +
                ", position=" + position +
                ", points=" + points +
                '}';
    }

}
