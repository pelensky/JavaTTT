package com.pelensky.tictactoe;

import com.pelensky.tictactoe.App.AppRunner;
import com.pelensky.tictactoe.App.IO;
import com.pelensky.tictactoe.Commands.Command;
import com.pelensky.tictactoe.Commands.ComputerVSComputer;
import com.pelensky.tictactoe.Commands.HumanVSComputer;
import com.pelensky.tictactoe.Commands.HumanVSHuman;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppRunnerTest {

    private ByteArrayOutputStream out;
    private IO io;

    private void run(String input) {
        out = new ByteArrayOutputStream();
        Scanner scanner = new Scanner(input);
        PrintStream output = new PrintStream(out);
        io = new IO(scanner, output);
        AppRunner appRunner = new AppRunner(io, commands()) ;
        appRunner.run();
    }

    private List<Command> commands() {
        return Arrays.asList(
                new HumanVSHuman(io),
                new HumanVSComputer(io, new MockRandom()),
                new ComputerVSComputer());
    }

    @Test
    public void welcomesUser() {
        run("3\n2\n");
        assertThat(out.toString(), containsString("Tic Tac Toe" + System.lineSeparator() + "Select Game Type"));
    }

    @Test
    public void selectGameType() {
        run("3\n2\n");
        assertThat(out.toString(), containsString("1) Human VS Human" + System.lineSeparator() + "2) Human VS Computer" + System.lineSeparator() + "3) Computer VS Computer"));
    }

    @Test
    public void quitGame() {
        run("3\n2\n");
        assertThat(out.toString(), containsString("Play again?" + System.lineSeparator() + "1) Yes" + System.lineSeparator() + "2) No" + System.lineSeparator() + "Exiting"));
    }

    @Test
    public void humanVShuman() {
        run("1\n0\n4\n2\n8\n1\n2\n");
        assertThat(out.toString(), containsString("X is the winner"));
    }

    @Test
    public void humanVShumanTiedGame() {
        run("1\n0\n4\n2\n1\n7\n3\n5\n8\n6\n2\n");
        assertThat(out.toString(), containsString("Game tied"));
    }

    @Test
    public void computerVScomputer(){
        run("3\n2");
        assertThat(out.toString(), containsString("Exiting"));
    }

    @Test
    public void humanVScomputerHumanFirst(){
        run("2\n1\n6\n7\n8\n2\n");
        assertThat(out.toString(), containsString("Who plays first?" + System.lineSeparator() + "1) Human" + System.lineSeparator() + "2) Computer"));
    }

    @Test
    public void humanVScomputerComputerFirst(){
        run("2\n2\n6\n7\n8\n2\n");
        assertThat(out.toString(), containsString("Exiting"));
    }

    @Test
    public void humanTriesAnIllegalMove() {
        run("1\n0\n4\n10\n2\n8\n1\n2\n");
        assertThat(out.toString(), containsString("Try again"));
    }

    @Test
    public void invalidSelection() {
        run("10\n3\n2\n");
        assertThat(out.toString(), containsString("Invalid selection"));
    }

}

