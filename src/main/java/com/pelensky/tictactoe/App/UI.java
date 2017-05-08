package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.Commands.Command;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.Player;

import java.io.PrintStream;
import java.util.List;

public class UI {

    private final PrintStream output;

    public UI(PrintStream output) {
        this.output = output;
    }

    void printWelcome() {
        output.println("Tic Tac Toe" + System.lineSeparator() + "Select Game Type");
    }

    public void printWhoPlaysFirst() {
        output.println("Who plays first?");
    }

    void printInvalidSelection() {
        output.println("Invalid selection");
    }

   void printExiting() {
        output.println("Exiting");
    }

    void printOptions(List<Command> options) {
        StringBuilder instructions = new StringBuilder();
        for (int i = 0; i < options.size(); i++) {
            instructions
                    .append(i + 1)
                    .append(") ")
                    .append(options.get(i).instruction())
                    .append(System.lineSeparator());
        }
        output.println(instructions.toString().trim());
    }

    public void printSelection(List<Player> playerTypes) {
        StringBuilder instructions = new StringBuilder();
        for (int i = 0; i < playerTypes.size(); i++) {
            instructions
                    .append(i + 1)
                    .append(") ")
                    .append(playerTypes.get(i).playerType())
                    .append(System.lineSeparator());
        }
        output.println(instructions.toString().trim());
    }

    void printSelectSpace(Game game) {
        output.println(game.currentPlayer.getMarker() + " select a space");
    }

    void printBoard(Game game) {
        String line = System.lineSeparator() + "-----------" + System.lineSeparator();
        output.println(formatRow(game, 0, 1, 2)
                + line
                + formatRow(game, 3, 4, 5)
                + line
                + formatRow(game, 6, 7, 8)
                + System.lineSeparator());
    }

    private String formatRow(Game game, int a, int b, int c) {
        return " " + getSpace(game, a) + " | " + getSpace(game, b) + " | " + getSpace(game, c);
    }

    private String getSpace(Game game, int index) {
        return game.getSpaces().get(index);
    }

    void printOutcome(Game game) {
        if (game.getWinner() != null) {
            output.println(game.getWinner().getMarker() + " is the winner");
        } else {
            output.println("Game tied");
        }
    }

    void printPlayAgain() {
        output.println("Play again?");
    }

}
