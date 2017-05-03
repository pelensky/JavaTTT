package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;

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
    public void takeTurn(Game game) {
        game.takeTurn(selectRandomAvailableSpace(game.board));
    }

    @Override
    public String playerType() {
        return "Computer";
    }

    public int selectRandomAvailableSpace(Board board){
        List<Integer> spaces = board.getAvailableSpaces();
        return spaces.get(random.nextInt(spaces.size()));
    }
}

