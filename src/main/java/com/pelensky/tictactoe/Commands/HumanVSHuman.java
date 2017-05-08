package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.App.Input;
import com.pelensky.tictactoe.App.UI;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Board;

public class HumanVSHuman implements Command {

  private final Input input;
  private final UI ui;

  public HumanVSHuman(Input input, UI ui) {
    this.input = input;
    this.ui = ui;
  }

  @Override
  public Game execute() {
    Player player1 = new HumanPlayer(input, ui, "X");
    Player player2 = new HumanPlayer(input, ui,  "O");
    Board board = new Board(3);
    return new Game(board, player1, player2);
  }

  @Override
  public String instruction() {
    return "Human VS Human";
  }
}
