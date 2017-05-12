package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Input;
import com.pelensky.tictactoe.Print;

public class HumanPlayer implements Player {

  private final String marker;
  private final Input input;
  private final Print print;

  public HumanPlayer(Input input, Print print, String marker) {
    this.marker = marker;
    this.print = print;
    this.input = input;
  }

  @Override
  public String getMarker() {
    return marker;
  }

  @Override
  public int getMove(Board board) {
    return input.validateSelection(board.getAvailableSpaces());
  }


  @Override
  public String title() {
    return "Human";
  }
}
