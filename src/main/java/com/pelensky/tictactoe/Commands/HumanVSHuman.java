package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.App.Input;
import com.pelensky.tictactoe.App.Print;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Board;

public class HumanVSHuman implements Command {

  private final Input input;
  private final Print print;

  public HumanVSHuman(Input input, Print print) {
    this.input = input;
    this.print = print;
  }

  @Override
  public Game execute() {
    Player player1 = new HumanPlayer(input, "X");
    Player player2 = new HumanPlayer(input, "O");
    Board board = new Board(3);
    return new Game(board, player1, player2);
  }

  @Override
  public String instruction() {
    return "Human VS Human";
  }
}
