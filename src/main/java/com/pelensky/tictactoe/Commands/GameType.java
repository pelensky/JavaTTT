package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.*;

public interface GameType extends Menu {
  Game execute(Board board);

  String title();
}
