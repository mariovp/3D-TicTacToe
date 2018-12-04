package com.valpa.player;

import com.valpa.board.Board3D;

public class SearchNode {

    private Board3D board3D;
    private PlayerMove playerMove;

    public SearchNode(Board3D board3D, PlayerMove playerMove) {
        this.board3D = board3D;
        this.playerMove = playerMove;
    }

    public Board3D getBoard3D() {
        return board3D;
    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }

}
