package com.pelensky.tictactoe.Boards;

import com.pelensky.tictactoe.Board;

public class NormalBoard implements Boards{
    @Override
    public Board execute() {
        return new Board(3);
    }

    @Override
    public String title() {
        return "Normal (3x3)";
    }
}
