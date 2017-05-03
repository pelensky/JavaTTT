package com.pelensky.tictactoe.App;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        AppRunner appRunner = new AppRunner(new IO(new Scanner(System.in), new PrintStream(System.out)), new Random());
        appRunner.run();
    }
}
