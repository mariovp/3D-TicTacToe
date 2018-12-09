package com.valpa.player;

import com.valpa.board.Board3D;
import com.valpa.board.Symbol;
import com.valpa.board.WinningLinesPositions;

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

    public boolean isTerminalNode() {

        for (int[] winLine : WinningLinesPositions.getInstance().getWinningLinesPositionArray()) {

            Symbol one = board3D.getCubeCell(winLine[0]);
            Symbol two = board3D.getCubeCell(winLine[1]);
            Symbol three = board3D.getCubeCell(winLine[2]);
            Symbol four = board3D.getCubeCell(winLine[3]);

            if (one != Symbol.EMPTY && one == two && two == three && three == four)
                return true;

        }

        return false;
    }

}
