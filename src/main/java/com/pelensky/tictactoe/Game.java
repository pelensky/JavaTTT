package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    final Board board;
    final Player player1;
    final Player player2;
    private final int numberOfRows;
    private final int offset;
    Player currentPlayer;
    private Player winner;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.numberOfRows = board.getNumberOfRows();
        this.offset = board.getOffset();
    }

    void takeTurn() {
        board.takeTurn(currentPlayer.getMove(board), currentPlayer.getMarker());
        changeCurrentPlayer();
    }

    private void changeCurrentPlayer() {
        currentPlayer =
                (currentPlayer.equals(player1)) ? (currentPlayer = player2) : (currentPlayer = player1);
    }

    boolean isGameOver() {
        return isGameWonBy(player1) || isGameWonBy(player2) || isGameTied();
    }

    Player getWinner() {
        return winner;
    }

    private boolean isGameWonBy(Player player) {
        for (ArrayList<String> line : winningCombinations()) {
            if (line.stream().allMatch(space -> space.equals(player.getMarker()))) {
                winner = player;
                return true;
            }
        }
        return false;
    }

    private boolean isGameTied() {
        return getAvailableSpaces().size() == 0 && !isGameWonBy(player1) && !isGameWonBy(player2);
    }

    private ArrayList<ArrayList<String>> getRows() {
        ArrayList<ArrayList<String>> rows = new ArrayList<>(numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            rows.add(
                    new ArrayList<>(
                            getSpaces().subList(i * numberOfRows, (numberOfRows * i) + numberOfRows)));
        }
        return rows;
    }

    private ArrayList<ArrayList<String>> getColumns() {
        ArrayList<ArrayList<String>> columns = new ArrayList<>(numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            ArrayList<String> column = new ArrayList<>(numberOfRows);
            for (int j = 0; j < numberOfRows; j++) {
                column.add(getRows().get(j).get(i));
            }
            columns.add(column);
        }
        return columns;
    }

    private ArrayList<String> getLeftDiagonal() {
        ArrayList<String> leftDiagonal = new ArrayList<>(numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            leftDiagonal.add(getRows().get(i).get(i));
        }
        return leftDiagonal;
    }

    private ArrayList<String> getRightDiagonal() {
        ArrayList<String> rightDiagonal = new ArrayList<>(numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            rightDiagonal.add(getRows().get(i).get(numberOfRows - (i + 1)));
        }
        return rightDiagonal;
    }

    private ArrayList<ArrayList<String>> winningCombinations() {
        ArrayList<ArrayList<String>> winningCombinations = new ArrayList<>();
        winningCombinations.addAll(getRows());
        winningCombinations.addAll(getColumns());
        winningCombinations.add(getLeftDiagonal());
        winningCombinations.add(getRightDiagonal());
        return winningCombinations;
    }

    private List<Integer> getAvailableSpaces() {
        return board.getAvailableSpaces();
    }

    List<String> getSpaces() {
        return board.getSpaces();
    }
}