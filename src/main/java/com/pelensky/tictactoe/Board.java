package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Board {
    private int numberOfRows;
    private List<String> spaces;

    Board(int numberOfRows) {
        this.numberOfRows = numberOfRows;
        this.spaces = new ArrayList<>(9);
        assignValues();
    }

    List<String> getSpaces() {
        return spaces;
    }

    List<Integer> getAvailableSpaces() {
        List<Integer> availableSpaces = new ArrayList<>();
        for (int i = 0; i < getSpaces().size(); i++){
            if (isSpaceTaken(getSpaces().get(i))){
                availableSpaces.add(i);
            }
        }
        return availableSpaces;
    }

    private boolean isSpaceTaken(String space) {
        return !Objects.equals(space, "X") && !Objects.equals(space, "O");
    }

   private void assignValues(){
        for (int i = 0; i < numberOfRows * numberOfRows; i++){
            getSpaces().add(String.valueOf(i));
        }
   }




}
