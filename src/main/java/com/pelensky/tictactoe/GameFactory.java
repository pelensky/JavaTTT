package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.ComputerPlayer;
import com.pelensky.tictactoe.Players.HumanPlayer;
import com.pelensky.tictactoe.Players.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class GameFactory {
  private Input input;
  private Random random;

  GameFactory(Input input, Random random) {
    this.input = input;
    this.random = random;
  }

  Game createGame(int selection, Board board) {
    Game game;
    if (selection == 1) {
      Player player1 = new HumanPlayer(input, "X");
      Player player2 = new HumanPlayer(input, "O");
      game = new Game(board, player1, player2);
    } else if (selection == 2) {
      Player player1 = new HumanPlayer(input, "X");
      Player player2 = new ComputerPlayer("O", random);
      game = new Game(board, player1, player2);
    } else if (selection == 3) {
      Player player1 = new ComputerPlayer("X", random);
      Player player2 = new HumanPlayer(input, "O");
      game = new Game(board, player1, player2);
    } else if (selection == 4) {
      Player player1 = new ComputerPlayer("X", random);
      Player player2 = new ComputerPlayer("O", random);
      game = new Game(board, player1, player2);
    } else {
      return createGame(selection, board);
    }
    return game;
  }

  List<String> gameTypes() {
    return Arrays.asList(
        "Human vs Human", "Human vs Computer", "Computer vs Human", "Computer vs Computer");
  }
}
