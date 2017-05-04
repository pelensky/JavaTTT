package com.pelensky.tictactoe.Players;

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
    public int getMove(int numberOfSpaces){
        return random.nextInt(numberOfSpaces);
    }

    @Override
    public String playerType() {
        return "Computer";
    }

}

