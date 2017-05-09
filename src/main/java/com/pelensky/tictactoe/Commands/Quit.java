package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.AppRunner;
import com.pelensky.tictactoe.Game;

public class Quit implements Command {

  private final AppRunner appRunner;

  public Quit(AppRunner appRunner) {
    this.appRunner = appRunner;
  }

  @Override
  public Game execute() {
    appRunner.quitApp();
    return null;
  }

  @Override
  public String instruction() {
    return "No";
  }
}
