package com.valpa;

public enum CubeCell {

    EMPTY(" . "), CROSS(" x "), CIRCLE(" o ");

    private String string;

    CubeCell(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

}
