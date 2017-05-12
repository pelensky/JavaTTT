package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Commands.Command;
import com.pelensky.tictactoe.Commands.ComputerVSComputer;
import com.pelensky.tictactoe.Commands.HumanVSComputer;
import com.pelensky.tictactoe.Commands.HumanVSHuman;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  private static Input input;
  private static AppRunner appRunner;
  private static Print print;
  private static Random random;

  public static void main(String[] args) {
    print = new Print(new PrintStream(System.out));
    input = new Input(new Scanner(System.in), print);
    random = new Random();
    appRunner = new AppRunner(input, print, commands());
    appRunner.run();
  }

  private static List<Command> commands() {
    return Arrays.asList(
        new HumanVSHuman(input, print), new HumanVSComputer(input, print, random), new ComputerVSComputer(random));
  }
}
