package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

  private final int numberOfRows;
  private final int totalSpaces;

  private final int offset;
  List<String> spaces;

  public Board(int numberOfRows) {
    this.numberOfRows = numberOfRows;
    this.totalSpaces = numberOfRows * numberOfRows;
    this.spaces = new ArrayList<>(totalSpaces);
    this.offset = 1;
    assignValuesToSpaces();
  }

  void placeMarker(int space, String marker) {
      getSpaces().set(space - offset, marker);
  }

  List<String> getSpaces() {
    return spaces;
  }

  int getNumberOfRows() {
    return numberOfRows;
  }

  public List<Integer> getAvailableSpaces() {
    List<Integer> availableSpaces = new ArrayList<>();
    for (int i = offset; i < getSpaces().size() + offset; i++) {
      if (isSpaceAvailable(i)) {
        availableSpaces.add(i);
      }
    }
    return availableSpaces;
  }

  private void assignValuesToSpaces() {
    for (int i = offset; i < totalSpaces + offset; i++) {
      getSpaces().add(String.valueOf(i));
    }
  }

  private boolean isSpaceAvailable(int space) {
    return getSpaces().get(space - offset).equals(String.valueOf(space));
  }
}