package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Board board;
    Player player1;
    Player player2;
    public Player currentPlayer;
    private int numberOfRows;
    private Player winner;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.numberOfRows = board.getNumberOfRows();
    }

    public void takeTurn(int space) {
        if (isMoveAllowed(space)) {
            board.takeTurn(space, currentPlayer.getMarker());
            changeCurrentPlayer();
        }
    }

    public boolean isMoveAllowed(int space) {
        return board.isMoveAllowed(space);
    }

    private void changeCurrentPlayer() {
        currentPlayer = (currentPlayer.equals(player1)) ? (currentPlayer = player2) : (currentPlayer = player1);
    }

    public boolean isGameOver() {
        return isGameWonBy(player1) || isGameWonBy(player2) || isGameTied();
    }

    public Player getWinner() {
        return winner;
    }

    private boolean isGameWonBy(Player player) {
        for (int i = 0; i < winningCombinations().size(); i++) {
            ArrayList<String> line = winningCombinations().get(i);
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
        ArrayList<ArrayList<String>> rows = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            rows.add(new ArrayList<>(getSpaces().subList(i * numberOfRows, (numberOfRows * i) + numberOfRows)));
        }
        return rows;
    }

    private ArrayList<ArrayList<String>> getColumns() {
        ArrayList<ArrayList<String>> columns = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            ArrayList<String> column = new ArrayList<>();
            for (int j = 0; j < numberOfRows; j++) {
                column.add(getRows().get(j).get(i));
            }
            columns.add(column);
        }
        return columns;
    }

    private ArrayList<String> getLeftDiagonal() {
        ArrayList<String> leftDiagonal = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            leftDiagonal.add(getRows().get(i).get(i));
        }
        return leftDiagonal;
    }

    private ArrayList<String> getRightDiagonal() {
        ArrayList<String> rightDiagonal = new ArrayList<>();
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

    public List<String> getSpaces() {
        return board.getSpaces();
    }
}