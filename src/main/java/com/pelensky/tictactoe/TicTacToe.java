package com.pelensky.tictactoe;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  public static void main(String[] args) {
    Print print = new Print(new PrintStream(System.out));
    Input input = new Input(new Scanner(System.in), print);
    Random random = new Random();
    BoardFactory boardFactory = new BoardFactory();
    GameFactory gameFactory = new GameFactory(input, random);
    AppRunner appRunner = new AppRunner(input, print, boardFactory, gameFactory);
    appRunner.run();
  }
}
