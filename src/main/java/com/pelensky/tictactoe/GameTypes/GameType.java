package com.pelensky.tictactoe.GameTypes;

import com.pelensky.tictactoe.*;


public interface GameType {
    Game execute();
    String instruction();
}
