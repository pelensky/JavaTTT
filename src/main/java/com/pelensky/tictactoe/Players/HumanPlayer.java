package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;

public class HumanPlayer implements Player {

    private String marker;

    public HumanPlayer(String marker){
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public void takeTurn(Board board, int space) {
        board.takeTurn(space, marker);
    }

    @Override
    public String playerType() {
        return "Human";
    }
}
