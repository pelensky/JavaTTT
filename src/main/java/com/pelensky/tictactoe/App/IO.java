package com.pelensky.tictactoe.App;

import java.io.PrintStream;
import java.util.Scanner;

public class IO {

  private final Scanner input;
  private final PrintStream output;

  public IO(Scanner input, PrintStream output) {
    this.input = input;
    this.output = output;
  }

  public String getInput() {
    return input.nextLine().trim();
  }

  public void print(String text) {
    output.println(text);
  }
}
