package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Game;

import java.util.List;
import java.util.Random;

public class RandomComputerPlayer implements Player {

    private final Random random;
    private final String marker;

    public RandomComputerPlayer(String marker, Random random) {
        this.marker = marker;
        this.random = random;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public int getMove(Game game) {
        return selectRandomAvailableSpace(game);
    }

    @Override
    public String title() {
        return "Computer";
    }

    private int selectRandomAvailableSpace(Game game) {
        List<Integer> spaces = game.board.getAvailableSpaces();
        return spaces.get(random.nextInt(spaces.size()));
    }
}
