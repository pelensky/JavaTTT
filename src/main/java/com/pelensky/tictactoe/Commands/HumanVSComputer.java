package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.Input;
import com.pelensky.tictactoe.Print;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.ComputerPlayer;
import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Board;

import java.util.ArrayList;
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
    print.clearScreen();
    print.whoPlaysFirst();
    print.selection(playerTypes());
    return playerTypes().get(getSelection(playerTypes()));
  }

  private int getSelection( List<Player> options) {
    return input.validateSelection(validSelections(options)) - 1;
  }

  private List<Player> playerTypes() {
    return Arrays.asList(new HumanPlayer(input, print,  "X"), new ComputerPlayer("X", random));
  }

  private List<Integer> validSelections(List<Player> options){
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i < options.size() + 1; i++) {
      list.add(i);
    }
    return list;
  }

  private Player setPlayer2(Player player1) {
    if (player1 instanceof HumanPlayer) {
      return new ComputerPlayer("O", random);
    } else {
      return new HumanPlayer(input, print,  "O");
    }
  }
}
