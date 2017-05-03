package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;

public interface Player {
    String getMarker();
    void takeTurn(Board board, int space);
    String playerType();
}
