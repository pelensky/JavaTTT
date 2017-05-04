package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.App.IO;

public class HumanPlayer implements Player {

    private final String marker;
    private final IO io;

    public HumanPlayer(IO io, String marker){
        this.marker = marker;
        this.io = io;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public int getMove(int numberOfSpaces) {
        return Integer.valueOf(io.getInput());
    }

    @Override
    public String playerType() {
        return "Human";
    }
}
