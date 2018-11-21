package com.valpa;

public enum Cell {

    EMPTY(" . "), CROSS(" x "), CIRCLE(" o ");

    private String string;

    Cell(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

}
