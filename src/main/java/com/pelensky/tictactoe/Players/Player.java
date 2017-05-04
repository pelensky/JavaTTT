package com.pelensky.tictactoe.Players;

public interface Player {
    String getMarker();
    int getMove(int numberOfSpaces);
    String playerType();
}
