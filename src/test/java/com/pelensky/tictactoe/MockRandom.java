package com.pelensky.tictactoe;

import java.util.Random;

public class MockRandom extends Random {

  private int number;

  private boolean hasComputerPlayed = false;

  MockRandom() {
    this.number = 0;
  }

  @Override
  public int nextInt(int bound) {
    hasComputerPlayed = true;
    return number;
  }

  boolean getHasComputerPlayed() {
    return hasComputerPlayed;
  }
}
