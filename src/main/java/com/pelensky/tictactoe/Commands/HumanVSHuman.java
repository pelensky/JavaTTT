package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Input;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.Player;

public class HumanVSHuman implements GameType {

  private final Input input;

  public HumanVSHuman(Input input) {
    this.input = input;
  }

  @Override
  public Game execute(Board board) {
    Player player1 = new HumanPlayer(input, "X");
    Player player2 = new HumanPlayer(input, "O");
    return new Game(board, player1, player2);
  }

  @Override
  public String title() {
    return "Human VS Human";
  }
}
