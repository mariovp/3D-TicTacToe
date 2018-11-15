package com.valpa;

public enum CellStatus {

    EMPTY(" . "), CROSS(" x "), CIRCLE(" o ");

    private String string;

    CellStatus(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
