package com.pelensky.tictactoe.GameTypes;

import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.HumanPlayer;
import com.pelensky.tictactoe.ComputerPlayer;
import com.pelensky.tictactoe.Player;
import com.pelensky.tictactoe.Board;

public class HumanVSComputer implements GameType {

    //TODO Ask if computer or player should go first
    @Override
    public Game execute() {
        Player player1 = new HumanPlayer("X");
        Player player2 = new ComputerPlayer("O");
        Board board = new Board(3);
        return new Game(board, player1, player2);
    }

    @Override
    public String instruction() {
        return "Human VS Computer";
    }
}
