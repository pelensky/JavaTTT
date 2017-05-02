package com.pelensky.tictactoe;

public interface Player {
    String getMarker();
    void takeTurn(Board board, int space);
    String playerType();
}
