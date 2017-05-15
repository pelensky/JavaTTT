package com.pelensky.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Print {

    private final PrintStream output;
    private final String CLEAR_SCREEN = "\033[H\033[2J";

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

    public void options(List<? extends Menu> options) {
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

    void board(Board board) {
        StringBuilder printedBoard = new StringBuilder();
        ArrayList<ArrayList<String>> rows = board.getRows();
        for (ArrayList<String> row : rows) {
            printedBoard.append(formatRow(row)).append(getLine(board));
        }
        printedBoard.append(System.lineSeparator());
        output.println(printedBoard.substring(0, printedBoard.length() - getLine(board).length()));
    }

    private String getLine(Board board) {
        final String line;
        if (board.getRows().size() == 3) {
            line = System.lineSeparator() + "-----------" + System.lineSeparator();
        } else {
            line = System.lineSeparator() + "---------------" + System.lineSeparator();
        }
        return line;
    }

    private String formatRow(List<String> row) {
        String separator = " | ";
        StringBuilder formattedRow = new StringBuilder(" ");
        for (String aRow : row) {
            formattedRow.append(aRow).append(separator);
        }
        return String.valueOf(formattedRow.substring(0, formattedRow.length() - separator.length()));
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

    public void clearScreen() {
        output.print(CLEAR_SCREEN);
        output.flush();
    }
}
