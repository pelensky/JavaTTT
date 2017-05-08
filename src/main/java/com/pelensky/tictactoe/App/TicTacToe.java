package com.pelensky.tictactoe.App;

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
  private static UI ui;
  private static Random random;

  public static void main(String[] args) {
    ui = new UI(new PrintStream(System.out));
    input = new Input(new Scanner(System.in), ui);
    random = new Random();
    appRunner = new AppRunner(input, ui, commands());
    appRunner.run();
  }

  private static List<Command> commands() {
    return Arrays.asList(
        new HumanVSHuman(input, ui), new HumanVSComputer(input, ui, random), new ComputerVSComputer());
  }
}
