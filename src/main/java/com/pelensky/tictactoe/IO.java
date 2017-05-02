package com.pelensky.tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public class IO {

    private Scanner input;
    private PrintStream output;

    IO(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input.nextLine().trim();
    }

    void print(String text) {
        output.println(text);
    }
}

