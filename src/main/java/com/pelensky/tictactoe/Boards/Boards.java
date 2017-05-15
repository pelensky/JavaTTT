package com.pelensky.tictactoe.Boards;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Menu;

public interface Boards extends Menu {
    Board execute();
    String title();
}
