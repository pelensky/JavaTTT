package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Menu;

public interface Player extends Menu {
    String getMarker();

    int getMove(Game game);

    String title();
}
