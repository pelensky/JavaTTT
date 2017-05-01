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
        } else {
            throw new IllegalMoveException();
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

    private void assignValues() {
        for (int i = 0; i < totalSpaces; i++) {
            getSpaces().add(String.valueOf(i));
        }
    }
    
    private boolean isSpaceAvailable(int i){
        return getSpaces().get(i).equals(String.valueOf(i));
    }

    int getNumberOfRows() {
        return numberOfRows;
    }


}