package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.App.Input;

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
  public int getMove(int numberOfSpaces) {
    return input.getInteger();
  }

  @Override
  public String playerType() {
    return "Human";
  }
}
