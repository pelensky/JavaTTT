package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.App.IO;

public class HumanPlayer implements Player {

    private String marker;
    private IO io;

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
            io.print("Try again");
        }
    }

    @Override
    public String playerType() {
        return "Human";
    }
}
