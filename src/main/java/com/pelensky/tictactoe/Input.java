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
        int selection = -1;
        while (selection < 0) {
            int proposedSelection = validateInput(input.nextLine().trim());
            if (proposedSelection != -1) {
               selection = proposedSelection;
            } else {
                print.invalidSelection();
            }
        }
        return selection;
    }

    private int validateInput(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
