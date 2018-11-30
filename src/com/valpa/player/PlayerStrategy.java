package com.valpa.player;

public enum PlayerStrategy {

    ATTACK(11,10), BALANCE(10,10), DEFENSE(10,11);

    private int aiPointBase;
    private int enemyPointBase;

    PlayerStrategy(int aiPointBase, int enemyPointBase) {
        this.aiPointBase = aiPointBase;
        this.enemyPointBase = enemyPointBase;
    }

    public int getAiPointBase() {
        return aiPointBase;
    }

    public int getEnemyPointBase() {
        return enemyPointBase;
    }

}
