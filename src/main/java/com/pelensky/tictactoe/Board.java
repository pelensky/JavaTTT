package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.List;

class Board {
    private int numberOfRows;
    private int totalSpaces;
    List<String> spaces;

    Board(int numberOfRows) {
        this.numberOfRows = numberOfRows;
        this.totalSpaces = numberOfRows * numberOfRows;
        this.spaces = new ArrayList<>();
        assignValues();
    }
    
    void takeTurn(int space, String marker){
        if (isSpaceAvailable(space)) {
            getSpaces().set(space, marker);
        }
    }

    List<String> getSpaces() {
        return spaces;
    }

    List<Integer> getAvailableSpaces() {
        List<Integer> availableSpaces = new ArrayList<>();
        for (int i = 0; i < getSpaces().size(); i++) {
            if (isSpaceAvailable(i)) {
                availableSpaces.add(i);
            }
        }
        return availableSpaces;
    }
    
    //TODO Remove hard coding of X and O
    boolean isGameOver() {
        return isGameWon("X") || isGameWon("O") || isGameTied();
    }

    private boolean isGameWon(String marker) {
        for (int i = 0; i < winningCombinations().size(); i++) {
            if (winningCombinations().get(i).stream().filter(space -> space.equals(marker))
                    .count() == numberOfRows) return true;
        }
        return false;
    }

    private boolean isGameTied() {
     return getAvailableSpaces().size() == 0 && !isGameWon("X") && !isGameWon("O");
    }

   private void assignValues() {
        for (int i = 0; i < totalSpaces; i++) {
            getSpaces().add(String.valueOf(i));
        }
    }

    private List<ArrayList> splitRows() {
        List<ArrayList> splitRows = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            splitRows.add(new ArrayList<>(getSpaces().subList(i * numberOfRows, (numberOfRows * i) + numberOfRows)));
        }
        return splitRows;
    }

    private List<ArrayList> splitColumns() {
        List<ArrayList> splitColumns = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            ArrayList<String> column = new ArrayList<>();
            for (int j = 0; j < numberOfRows; j++) {
                column.add((String) splitRows().get(j).get(i));
            }
            splitColumns.add(column);
        }
        return splitColumns;
    }

    private List<String> splitLeftDiagonal() {
        ArrayList<String> leftDiagonal = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            leftDiagonal.add((String) splitRows().get(i).get(i));
        }
        return leftDiagonal;
    }

    private List<String> splitRightDiagonal() {
        ArrayList<String> rightDiagonal = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            rightDiagonal.add((String) splitRows().get(i).get(numberOfRows - (i + 1)));
        }
        return rightDiagonal;
    }

    private List<ArrayList> winningCombinations() {
        List<ArrayList> winningCombinations = new ArrayList<>();
        winningCombinations.addAll(splitRows());
        winningCombinations.addAll(splitColumns());
        winningCombinations.add((ArrayList) splitLeftDiagonal());
        winningCombinations.add((ArrayList) splitRightDiagonal());
        return winningCombinations;
    }

    private boolean isSpaceAvailable(int i){
        return getSpaces().get(i).equals(String.valueOf(i));
    }

}