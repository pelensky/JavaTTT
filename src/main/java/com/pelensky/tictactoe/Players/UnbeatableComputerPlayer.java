package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Game;

public class UnbeatableComputerPlayer implements Player {

    private final String marker;

    public UnbeatableComputerPlayer(String marker) {
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public int getMove(Game game) {
      return game.board.getAvailableSpaces().get(0);

    }

    @Override
    public String title() {
        return null;
    }
}
