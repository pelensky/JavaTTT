package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {

  private final Scanner input;
  private final Print print;

  Input(Scanner input, Print print) {
    this.input = input;
    this.print = print;
  }

  int getInteger() {
    try {
      return input.nextInt();
    } catch (InputMismatchException e) {
      print.invalidSelection();
      input.next();
      return getInteger();
    }
  }

  public int validateSelection(List<Integer> options) {
    int selection = getInteger();
    if (options.contains(selection)) {
      return selection;
    } else {
      print.invalidSelection();
      return validateSelection(options);
    }
  }

  List<Integer> validSelections(List<String> list) {
    List<Integer> count = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      count.add(i + 1);
    }
    return count;
  }
}
