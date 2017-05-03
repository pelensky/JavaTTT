package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.App.IO;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Board;

public class HumanVSHuman implements Command {

    private IO io;

    public HumanVSHuman(IO io) {
        this.io = io;
    }

    @Override
    public Game execute() {
        Player player1 = new HumanPlayer(io, "X");
        Player player2 = new HumanPlayer(io, "O");
        Board board = new Board(3);
        return new Game(board, player1, player2);
}

    @Override
    public String instruction() {
        return "Human VS Human";
    }
}
