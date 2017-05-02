package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppRunnerTest {

    private ByteArrayOutputStream out;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
    }


    private void run(String input) {
        Scanner scanner = new Scanner(input);
        PrintStream output = new PrintStream(out);
        AppRunner appRunner = new AppRunner(new IO(scanner, output));
        appRunner.run();
    }

    @Test
    public void welcomesUser() {
        run("5");
        assertThat(out.toString(), containsString("Tic Tac Toe"));
    }
}

