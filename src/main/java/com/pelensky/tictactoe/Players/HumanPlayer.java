package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.App.IO;
import com.pelensky.tictactoe.App.Input;

public class HumanPlayer extends Input implements Player {

  private final String marker;
  private final IO io;

  public HumanPlayer(IO io, String marker) {
    super(io);
    this.marker = marker;
    this.io = io;
  }

  @Override
  public String getMarker() {
    return marker;
  }

  @Override
  public int getMove(int numberOfSpaces) {
    return getInteger();
  }

  @Override
  public String playerType() {
    return "Human";
  }
}
