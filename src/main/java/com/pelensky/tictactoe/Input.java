package com.pelensky.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private final Scanner input;
    private final Print print;

    Input(Scanner input, Print print) {
        this.input = input;
        this.print = print;
    }

    public int getInteger(){
        try {
           return input.nextInt();
        } catch (InputMismatchException e) {
            print.invalidSelection();
            input.next();
            return getInteger();
        }

    }
}
