package com.valpa.player;

public class PlayerMove {

    private int position;
    private int points;

    public PlayerMove(int position, int points) {
        this.position = position;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "PlayerMove{" +
                "position=" + position +
                ", points=" + points +
                '}';
    }

}
