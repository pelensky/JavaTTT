package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Input;
import com.pelensky.tictactoe.Players.RandomComputerPlayer;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Print;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HumanVSComputer implements GameType {

    private final Input input;
    private final Print print;
    private final Random random;

    public HumanVSComputer(Input input, Print print, Random random) {
        this.input = input;
        this.print = print;
        this.random = random;
    }

    @Override
    public Game execute(Board board) {
        Player player1 = selectFirstPlayer();
        Player player2 = setPlayer2(player1);
        return new Game(board, player1, player2);
    }

    @Override
    public String title() {
        return "Human VS Computer";
    }

    private Player selectFirstPlayer() {
        print.clearScreen();
        print.whoPlaysFirst();
        print.options(playerTypes());
        return playerTypes().get(getSelection(playerTypes()));
    }

    private int getSelection(List<Player> options) {
        return input.validateSelection(input.validSelections(options)) - 1;
    }

    private List<Player> playerTypes() {
        return Arrays.asList(new HumanPlayer(input, "X"), new RandomComputerPlayer("X", random));
    }

    private Player setPlayer2(Player player1) {
        if (player1 instanceof HumanPlayer) {
            return new RandomComputerPlayer("O", random);
        } else {
            return new HumanPlayer(input,"O");
        }
    }
}
