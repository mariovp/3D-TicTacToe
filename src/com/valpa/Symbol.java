package com.valpa;

public enum Symbol {

    EMPTY(" . "), CROSS(" x "), CIRCLE(" o ");

    private String string;

    Symbol(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

}
