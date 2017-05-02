package com.pelensky.tictactoe.GameTypes;

import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.HumanPlayer;
import com.pelensky.tictactoe.Player;
import com.pelensky.tictactoe.Board;

public class HumanVSHuman implements GameType {
    @Override
    public Game execute() {
        Player player1 = new HumanPlayer("X");
        Player player2 = new HumanPlayer("O");
        Board board = new Board(3);
        return new Game(board, player1, player2);
}

    @Override
    public String instruction() {
        return "Human VS Human";
    }
}
