package com.pelensky.tictactoe;

public class HumanPlayer implements Player {

    private String marker;

    HumanPlayer(String marker){
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


}
