package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.App.Input;
import com.pelensky.tictactoe.App.Print;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.ComputerPlayer;
import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Board;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HumanVSComputer implements Command {

  private final Input input;
  private final Print print;
  private final Random random;

  public HumanVSComputer(Input input, Print print, Random random) {
    this.input = input;
    this.print = print;
    this.random = random;
  }

  @Override
  public Game execute() {
    Player player1 = selectFirstPlayer();
    Player player2 = setPlayer2(player1);
    Board board = new Board(3);
    return new Game(board, player1, player2);
  }

  @Override
  public String instruction() {
    return "Human VS Computer";
  }

  private Player selectFirstPlayer() {
    print.whoPlaysFirst();
    print.selection(playerTypes());
    return playerTypes().get(input.getInteger() - 1);
  }

  private List<Player> playerTypes() {
    return Arrays.asList(new HumanPlayer(input,  "X"), new ComputerPlayer("X", random));
  }

  private Player setPlayer2(Player player1) {
    if (player1 instanceof HumanPlayer) {
      return new ComputerPlayer("O", random);
    } else {
      return new HumanPlayer(input,  "O");
    }
  }
}
