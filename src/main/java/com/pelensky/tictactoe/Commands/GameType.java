package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Menu;

public interface GameType extends Menu {
  Game execute(Board board);

  String title();
}
