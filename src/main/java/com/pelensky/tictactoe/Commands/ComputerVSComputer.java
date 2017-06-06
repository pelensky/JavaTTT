package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.RandomComputerPlayer;
import com.pelensky.tictactoe.Players.Player;

import java.util.Random;

public class ComputerVSComputer implements GameType {
    private final Random random;

    public ComputerVSComputer(Random random) {
        this.random = random;
    }

    @Override
    public Game execute(Board board) {
        Player player1 = new RandomComputerPlayer("X", random);
        Player player2 = new RandomComputerPlayer("O", random);
        return new Game(board, player1, player2);
    }

    @Override
    public String title() {
        return "Computer VS Computer";
    }
}
