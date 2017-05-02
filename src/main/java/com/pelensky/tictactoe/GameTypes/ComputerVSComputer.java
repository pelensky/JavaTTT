package com.pelensky.tictactoe.GameTypes;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.ComputerPlayer;
import com.pelensky.tictactoe.Player;

import java.util.Random;

public class ComputerVSComputer implements GameType{
    @Override
    public Game execute() {
        Player player1 = new ComputerPlayer("X", new Random());
        Player player2 = new ComputerPlayer("O", new Random());
        Board board = new Board(3);
        return new Game(board, player1, player2);
    }

    @Override
    public String instruction() {
        return "Computer VS Computer";
    }
}
