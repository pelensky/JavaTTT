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
        run("4");
        assertThat(out.toString(), containsString("Tic Tac Toe" + System.lineSeparator() + "Select Game Type"));
    }

    @Test
    public void selectGameType() {
        run("4");
        assertThat(out.toString(), containsString("1) Human VS Human" + System.lineSeparator() + "2) Human VS Computer" + System.lineSeparator() + "3) Computer VS Computer" + System.lineSeparator() + "4) Quit"));
    }

    @Test
    public void quitGame() {
        run("4");
        assertThat(out.toString(), containsString("Exiting"));
    }

    @Test
    public void humanVShuman() {
        run("1\n0\n4\n2\n8\n1\n4\n");
        assertThat(out.toString(), containsString("X is the winner"));
    }

    @Test
    public void computerVScomputer(){
        run("3\n4\n");
        assertThat(out.toString(), containsString("Exiting"));
    }



}

