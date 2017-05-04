package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.App.IO;
import com.pelensky.tictactoe.Game;

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
    public void takeTurn(Game game) {
        int proposedSpace = Integer.valueOf(io.getInput());
        if (game.isMoveAllowed(proposedSpace)) {
            game.takeTurn(proposedSpace);
        } else {
            io.print("Try again" + System.lineSeparator());
        }
    }

    @Override
    public String playerType() {
        return "Human";
    }
}
