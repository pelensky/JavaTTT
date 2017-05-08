package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.Commands.Command;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.Player;

import java.util.List;

public class UI {

    private final IO io;

    public UI(IO io) {
        this.io = io;
    }

    void welcome() {
        io.print("Tic Tac Toe" + System.lineSeparator() + "Select Game Type");
    }

    protected void printWhoPlaysFirst() {
        io.print("Who plays first?");
    }

    void printInvalidSelection() {
        io.print("Invalid selection");
    }

    void printExiting() {
        io.print("Exiting");
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
        io.print(instructions.toString().trim());
    }

    protected void printSelection(List<Player> playerTypes) {
        StringBuilder instructions = new StringBuilder();
        for (int i = 0; i < playerTypes.size(); i++) {
            instructions
                    .append(i + 1)
                    .append(") ")
                    .append(playerTypes.get(i).playerType())
                    .append(System.lineSeparator());
        }
        io.print(instructions.toString().trim());
    }

    void printSelectSpace(Game game) {
        io.print(game.currentPlayer.getMarker() + " select a space");
    }

    void printBoard(Game game) {
        String line = System.lineSeparator() + "-----------" + System.lineSeparator();
        io.print(formatRow(game, 0, 1, 2)
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
            io.print(game.getWinner().getMarker() + " is the winner");
        } else {
            io.print("Game tied");
        }
    }

    void printPlayAgain() {
        io.print("Play again?");
    }

    protected int getInteger() {
        int integer = -1;
        while (integer < 0) {
            String selection = io.getInput();
            if (validateInput(selection)) {
                integer = Integer.parseInt(selection);
            } else {
                io.print("Please select an integer");
            }
        }
        return integer;
    }

    private boolean validateInput(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
