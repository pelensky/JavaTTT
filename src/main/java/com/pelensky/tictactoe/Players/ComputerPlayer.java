package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;

import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

  private final Random random;
  private final String marker;

  public ComputerPlayer(String marker, Random random) {
    this.marker = marker;
    this.random = random;
  }

  @Override
  public String getMarker() {
    return marker;
  }

  @Override
  public int getMove(Board board) {
    return selectRandomAvailableSpace(board);
  }

  private int selectRandomAvailableSpace(Board board) {
    List<Integer> spaces = board.getAvailableSpaces();
    return spaces.get(random.nextInt(spaces.size()));
  }
}
