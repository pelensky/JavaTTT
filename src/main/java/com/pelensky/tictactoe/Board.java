package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

  private final int numberOfRows;
  private final int totalSpaces;
  List<String> spaces;

  public Board(int numberOfRows) {
    this.numberOfRows = numberOfRows;
    this.totalSpaces = numberOfRows * numberOfRows;
    this.spaces = new ArrayList<>(totalSpaces);
    assignValues();
  }

  void takeTurn(int space, String marker) {
      getSpaces().set(space, marker);
  }

  boolean isMoveAllowed(int space) {
    return (isSpaceOnBoard(space) && isSpaceAvailable(space));
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

  private boolean isSpaceAvailable(int space) {
    return getSpaces().get(space).equals(String.valueOf(space));
  }

  private boolean isSpaceOnBoard(int space) {
    return (space >= 0 && space < totalSpaces);
  }

  int getNumberOfRows() {
    return numberOfRows;
  }
}