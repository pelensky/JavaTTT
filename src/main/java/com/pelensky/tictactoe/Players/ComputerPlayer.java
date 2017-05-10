package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;

import java.util.List;
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
  public int getMove(Board board) {
    return selectRandomAvailableSpace(board);
  }

  @Override
  public String playerType() {
    return "Computer";
  }

  private int selectRandomAvailableSpace(Board board){
    List<Integer> spaces = board.getAvailableSpaces();
    return spaces.get(random.nextInt(spaces.size()));
  }
}
