package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Menu;

public interface Player extends Menu{
  String getMarker();

  int getMove(Board board);

  String title();
}
