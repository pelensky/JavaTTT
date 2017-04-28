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

    List<ArrayList> isGameOver(){
        return winningCombinations();
    }

    private boolean isSpaceTaken(String space) {
        return !Objects.equals(space, "X") && !Objects.equals(space, "O");
    }

   private void assignValues(){
        for (int i = 0; i < numberOfRows * numberOfRows; i++){
            getSpaces().add(String.valueOf(i));
        }
   }

   private List<ArrayList> splitRows() {
       List<ArrayList> splitRows = new ArrayList<>();
       for (int i = 0; i < numberOfRows; i++){
           splitRows.add(new ArrayList<>(getSpaces().subList(i * numberOfRows, (numberOfRows * i) + numberOfRows)));
       }
    return splitRows;
   }

   private List<ArrayList> splitColumns() {
    List<ArrayList> splitColumns = new ArrayList<>();
    for (int i = 0; i < numberOfRows; i++){
        ArrayList<String> column = new ArrayList<>();
        for (int j = 0; j < numberOfRows; j++){
            column.add((String) splitRows().get(j).get(i));
        }
       splitColumns.add(column);
    }
    return splitColumns;
   }

   private List<String> splitLeftDiagonal() {
       ArrayList<String> leftDiagonal = new ArrayList<>();
       for (int i = 0; i < numberOfRows; i ++){
           leftDiagonal.add((String) splitRows().get(i).get(i));
       }
       return leftDiagonal;
   }

   private List<String> splitRightDiagonal() {
       ArrayList<String> rightDiagonal = new ArrayList<>();
       for (int i = 0; i < numberOfRows; i++){
           rightDiagonal.add((String) splitRows().get(i).get(numberOfRows - ( i + 1)));
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

}