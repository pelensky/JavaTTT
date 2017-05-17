package com.pelensky.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Print {

    private final PrintStream output;

    Print(PrintStream output) {
        this.output = output;
    }

    void welcome() {
        output.println("Tic Tac Toe");
    }

    void gameType() {
        output.println("Select Game Type");
    }

    void boardSize(List<Integer> options){
        output.println("Select Board Size");
        output.println(options);
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

    private String formatRow(List<String> row) {
        String separator = " | ";
        String offset = " ";
        StringBuilder formattedRow = new StringBuilder(offset);
        for (String space : row) {
            String paddedSpace = padSpace(offset, space);
            formattedRow.append(paddedSpace).append(separator);
        }
        return String.valueOf(formattedRow.substring(0, formattedRow.length() - separator.length()));
    }

    private String padSpace(String offset, String space) {
        String paddedSpace;
        if (space.length() == 1){
            paddedSpace = offset + space;
        } else {
            paddedSpace = space;
        }
        return paddedSpace;
    }

    private String getLine(Board board) {
        final String line;
        int normalBoard = 3;
        if (board.getRows().size() == normalBoard) {
            line = System.lineSeparator() + "--------------" + System.lineSeparator();
        } else {
            line = System.lineSeparator() + "-------------------" + System.lineSeparator();
        }
        return line;
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
        final String CLEAR_SCREEN = "\033[H\033[2J";
        output.print(CLEAR_SCREEN);
        output.flush();
    }
}

