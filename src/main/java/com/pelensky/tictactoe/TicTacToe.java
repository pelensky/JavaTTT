package com.pelensky.tictactoe;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static Input input;
    private static Print print;
    private static Random random;

    public static void main(String[] args) {
        print = new Print(new PrintStream(System.out));
        input = new Input(new Scanner(System.in), print);
        random = new Random();
        BoardFactory boardFactory = new BoardFactory();
        GameFactory gameFactory = new GameFactory(input, random);
        AppRunner appRunner = new AppRunner(input, print, boardFactory, gameFactory);
        appRunner.run();
    }

}
