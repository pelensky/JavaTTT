package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.*;

import java.io.PrintStream;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        AppRunner appRunner = new AppRunner(new IO(new Scanner(System.in), new PrintStream(System.out)));
        appRunner.run();
    }
}
