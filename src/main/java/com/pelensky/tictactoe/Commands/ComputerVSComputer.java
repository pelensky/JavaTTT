package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.ComputerPlayer;
import com.pelensky.tictactoe.Players.Player;

import java.util.Random;

public class ComputerVSComputer implements Command {
    private final Random random;

    public ComputerVSComputer(Random random) {
        this.random = random;
    }

    @Override
    public Game execute() {
        Player player1 = new ComputerPlayer("X", random);
        Player player2 = new ComputerPlayer("O", random);
        Board board = new Board(3);
        return new Game(board, player1, player2);
    }

    @Override
    public String title() {
        return "Computer VS Computer";
    }
}
