package com.pelensky.tictactoe.App;

import java.util.Scanner;

public class Input {

  private final Scanner input;
  private final Print print;

  public Input(Scanner input, Print print) {
    this.input = input;
    this.print = print;
  }

  public int getInteger() {
    int integer = -1;
    while (integer < 0) {
      String selection = input.nextLine().trim();
      if (validateInput(selection)) {
        integer = Integer.parseInt(selection);
      } else {
        print.invalidSelection();
      }
    }
    return integer;
  }



  private boolean validateInput(String text) {
    try {
      Integer.parseInt(text);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }

  }

}
