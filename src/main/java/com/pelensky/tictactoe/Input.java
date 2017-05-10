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
        int integer = -1;
        while (integer < 0) {
            int selection = validateInput(input.nextLine().trim());
            if (selection != -1) {
               integer = selection;
            } else {
                print.invalidSelection();
            }
        }
        return integer;
    }

    private int validateInput(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}