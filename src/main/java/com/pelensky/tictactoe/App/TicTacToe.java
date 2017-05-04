package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.Commands.Command;
import com.pelensky.tictactoe.Commands.ComputerVSComputer;
import com.pelensky.tictactoe.Commands.HumanVSComputer;
import com.pelensky.tictactoe.Commands.HumanVSHuman;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static IO io;
    private static AppRunner appRunner;
    private static Random random;

    public static void main(String[] args) {
        io = new IO(new Scanner(System.in), new PrintStream(System.out));
        random = new Random();
        appRunner = new AppRunner(io, commands());
        appRunner.run();
    }

    private static List<Command> commands() {
        return Arrays.asList(
                new HumanVSHuman(io),
                new HumanVSComputer(io, random),
                new ComputerVSComputer());
    }
}
