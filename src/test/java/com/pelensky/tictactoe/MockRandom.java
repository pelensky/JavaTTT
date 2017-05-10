package com.pelensky.tictactoe;

import java.util.Random;

public class MockRandom extends Random {

  private int number;

  MockRandom() {
    this.number = 0;
  }

  @Override
  public int nextInt(int bound) {
    return number;
  }
}
