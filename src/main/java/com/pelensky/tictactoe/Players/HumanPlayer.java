package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Input;

public class HumanPlayer implements Player {

  private final String marker;
  private final Input input;

  public HumanPlayer(Input input, String marker) {
    this.marker = marker;
    this.input = input;

  }

  @Override
  public String getMarker() {
    return marker;
  }

  @Override
  public int getMove(Board board) {
    return input.getInteger() - board.getOffset();
  }

  @Override
  public String playerType() {
    return "Human";
  }
}
