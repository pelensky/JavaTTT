package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.*;

public interface Command extends Menu {
  Game execute();

  String title();
}
