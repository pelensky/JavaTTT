package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Game;

public interface Player {
    String getMarker();
    void takeTurn(Game game);
    String playerType();
}
