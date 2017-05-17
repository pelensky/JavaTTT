package com.pelensky.tictactoe;

import java.util.Arrays;
import java.util.List;

class PlayAgain {

  void playAgain(int option, AppRunner appRunner) {
    if (option == 2) {
      appRunner.quitApp();
    }
  }

  List<String> quitOptions() {
    return Arrays.asList("Yes", "No");
  }
}
