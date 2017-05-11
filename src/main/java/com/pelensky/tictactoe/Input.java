package com.pelensky.tictactoe;

import java.util.Scanner;

public class Input {

    private final Scanner input;
    private final Print print;

    Input(Scanner input, Print print) {
        this.input = input;
        this.print = print;
    }

    public int getInteger() {
        String selection = input.nextLine().trim();
        if (isAValidInput(selection)) {
            return Integer.parseInt(selection);
        } else {
            print.invalidSelection();
            return getInteger();
        }
    }

    private boolean isAValidInput(String selection) {
        try {
            Integer.parseInt(selection);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
