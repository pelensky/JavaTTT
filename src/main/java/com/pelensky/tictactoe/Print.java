package com.pelensky.tictactoe;

import java.io.PrintStream;
import java.util.List;

public class Print {

    private final PrintStream output;

    Print(PrintStream output) {
        this.output = output;
    }

    void welcome() {
        output.println("Tic Tac Toe" + System.lineSeparator() + "Select Game Type");
    }

    public void whoPlaysFirst() {
        output.println("Who plays first?");
    }

    void invalidSelection() {
        output.println("Select a Valid Number");
    }

    void exiting() {
        output.println("Exiting");
    }

    public void options(List<? extends Menu > options) {
        StringBuilder instructions = new StringBuilder();
        for (int i = 0; i < options.size(); i++) {
            instructions
                    .append(i + 1)
                    .append(") ")
                    .append(options.get(i).title())
                    .append(System.lineSeparator());
        }
        output.println(instructions.toString().trim());
    }

    void selectSpace(Game game) {
        output.println(game.currentPlayer.getMarker() + " select a space");
    }

    void board(Game game) {
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
        return game.board.getSpaces().get(index);
    }

    void outcome(Game game) {
        if (game.getWinner() != null) {
            output.println(game.getWinner().getMarker() + " is the winner");
        } else {
            output.println("Game tied");
        }
    }

    void playAgain() {
        output.println("Play again?");
    }

    public void clearScreen(){
            output.print("\033[H\033[2J");
            output.flush();
        }
}
