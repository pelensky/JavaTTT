package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.*;


public interface Command {
    Game execute();
    String instruction();
}
