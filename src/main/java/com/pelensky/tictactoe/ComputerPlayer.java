package com.pelensky.tictactoe;

import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    private String marker;

    ComputerPlayer(String marker){
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public void takeTurn(Board board, int space) {
        board.takeTurn(space, marker);
    }

    int selectRandomAvailableSpace(Board board){
        List<Integer> spaces = board.getAvailableSpaces();
        return spaces.get(new Random().nextInt(spaces.size()));
    }
}

