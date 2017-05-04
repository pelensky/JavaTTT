package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.Game;

public class PlayAgain implements Command {

  @Override
  public Game execute() {
    return null;
  }

  @Override
  public String instruction() {
    return "Yes";
  }
}
