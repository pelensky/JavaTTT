package com.pelensky.tictactoe.Players;

import java.util.Random;

public class ComputerPlayer implements Player {

  private final Random random;
  private final String marker;
  private final int offset;

  public ComputerPlayer(String marker, Random random) {
    this.marker = marker;
    this.random = random;
    this.offset = 1;
  }

  @Override
  public String getMarker() {
    return marker;
  }

  @Override
  public int getMove(int numberOfSpaces) {
    return random.nextInt(numberOfSpaces + offset);
  }

  @Override
  public String playerType() {
    return "Computer";
  }
}
