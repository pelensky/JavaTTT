package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.App.UI;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.ComputerPlayer;
import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Board;
import com.pelensky.tictactoe.App.IO;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HumanVSComputer extends UI implements Command {

  private final IO io;
  private final Random random;

  public HumanVSComputer(IO io, Random random) {
    super(io);
    this.io = io;
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
    printWhoPlaysFirst();
    printSelection(playerTypes());
    return playerTypes().get(getInteger() - 1);
  }

  private List<Player> playerTypes() {
    return Arrays.asList(new HumanPlayer(io, "X"), new ComputerPlayer("X", random));
  }

  private Player setPlayer2(Player player1) {
    if (player1 instanceof HumanPlayer) {
      return new ComputerPlayer("O", random);
    } else {
      return new HumanPlayer(io, "O");
    }
  }
}
