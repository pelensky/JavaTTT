package com.pelensky.tictactoe.Boards;

import com.pelensky.tictactoe.Board;

public class BigBoard implements Boards {
    @Override
    public Board execute() {
        return new Board(4);
    }

    @Override
    public String title() {
        return "Large (4x4)";
    }
}
