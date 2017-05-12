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

    public List<Integer> validSelections(List<? extends Menu> options) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < options.size() + 1; i++) {
            list.add(i);
        }
        return list;
    }
}
