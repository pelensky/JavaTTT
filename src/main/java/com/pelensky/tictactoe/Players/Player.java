package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;

public interface Player {
  String getMarker();

  int getMove(Board board);
}
