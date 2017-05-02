package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {

    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;
    private int numberOfRows;
    private Player winner;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.numberOfRows = board.getNumberOfRows();
    }

    void takeTurn(int space) {
        board.takeTurn(space, currentPlayer.getMarker());
        changeCurrentPlayer();
    }

    private void changeCurrentPlayer() {
        currentPlayer = (currentPlayer.equals(player1)) ? (currentPlayer = player2) : (currentPlayer = player1);
    }

    boolean isGameOver() {
        return isGameWonBy(player1) || isGameWonBy(player2) || isGameTied();
    }

    Player getWinner() {
        return winner;
    }

    private boolean isGameWonBy(Player player) {
        for (int i = 0; i < winningCombinations().size(); i++) {
            if (winningCombinations().get(i).stream().filter(space -> space.equals(player.getMarker()))
                    .count() == numberOfRows) {
                this.winner = player;
                return true;
            }
        }
        return false;
    }

    private boolean isGameTied() {
        return getAvailableSpaces().size() == 0 && !isGameWonBy(player1) && !isGameWonBy(player2);
    }

    private List<ArrayList> splitBoardIntoRows() {
        List<ArrayList> splitRows = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            splitRows.add(new ArrayList<>(getSpaces().subList(i * numberOfRows, (numberOfRows * i) + numberOfRows)));
        }
        return splitRows;
    }

    private List<ArrayList> splitBoardIntoColumns() {
        List<ArrayList> splitColumns = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            ArrayList<String> column = new ArrayList<>();
            for (int j = 0; j < numberOfRows; j++) {
                column.add((String) splitBoardIntoRows().get(j).get(i));
            }
            splitColumns.add(column);
        }
        return splitColumns;
    }

    private List<String> getLeftDiagonal() {
        ArrayList<String> leftDiagonal = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            leftDiagonal.add((String) splitBoardIntoRows().get(i).get(i));
        }
        return leftDiagonal;
    }

    private List<String> getRightDiagonal() {
        ArrayList<String> rightDiagonal = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            rightDiagonal.add((String) splitBoardIntoRows().get(i).get(numberOfRows - (i + 1)));
        }
        return rightDiagonal;
    }

    private List<ArrayList> winningCombinations() {
        List<ArrayList> winningCombinations = new ArrayList<>();
        winningCombinations.addAll(splitBoardIntoRows());
        winningCombinations.addAll(splitBoardIntoColumns());
        winningCombinations.add((ArrayList) getLeftDiagonal());
        winningCombinations.add((ArrayList) getRightDiagonal());
        return winningCombinations;
    }

    private List<Integer> getAvailableSpaces() {
        return board.getAvailableSpaces();
    }

    List<String> getSpaces() {
        return board.getSpaces();
    }
}
