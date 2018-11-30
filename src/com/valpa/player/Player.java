package com.valpa.player;

import com.valpa.board.Symbol;

public abstract class Player {

    protected Symbol symbol;
    protected Symbol enemySymbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
        this.enemySymbol = this.symbol == Symbol.CROSS ? Symbol.CIRCLE : Symbol.CROSS;
    }

    public abstract PlayerMove makeMove();

}
