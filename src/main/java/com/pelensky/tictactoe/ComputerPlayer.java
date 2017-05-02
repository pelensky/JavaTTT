package com.pelensky.tictactoe;

import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    private Random random;
    private String marker;

    public ComputerPlayer(String marker, Random random){
        this.marker = marker;
        this.random = random;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public void takeTurn(Board board, int space) {
        board.takeTurn(space, marker);
    }

    @Override
    public String playerType() {
        return "Computer";
    }

    int selectRandomAvailableSpace(Board board){
        List<Integer> spaces = board.getAvailableSpaces();
        return spaces.get(random.nextInt(spaces.size()));
    }
}

