package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Commands.GameType;
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
  private Input input;
  private Print print;

  private void run(String text) {
    out = new ByteArrayOutputStream();
    Scanner scanner = new Scanner(text);
    PrintStream output = new PrintStream(out);
    print = new Print(output);
    input = new Input(scanner, print);
    AppRunner appRunner = new AppRunner(input, print, commands());
    appRunner.run();
  }

  private List<GameType> commands() {
    return Arrays.asList(
        new HumanVSHuman(input), new HumanVSComputer(input, print, new FakeRandom()), new ComputerVSComputer(new FakeRandom()));
  }

  @Test
  public void welcomesUser() {
    run("2\n3\n2\n");
    assertThat(
        out.toString(),
        containsString("Tic Tac Toe" + System.lineSeparator() + "Select Board Size" + System.lineSeparator() + "1) Normal (3x3)" + System.lineSeparator() + "2) Large (4x4)"));
  }

  @Test
  public void selectsBoardSize(){
    run("1\n3\n2\n");
    assertThat(
            out.toString(),
            containsString("Select Game Type" + System.lineSeparator() + "1) Human VS Human" + System.lineSeparator() + "2) Human VS Computer" + System.lineSeparator() + "3) Computer VS Computer"));
  }


  @Test
  public void selectGameType() {
    run("1\n3\n2\n");
    assertThat(
        out.toString(),
        containsString(
            "1) Human VS Human"
                + System.lineSeparator()
                + "2) Human VS Computer"
                + System.lineSeparator()
                + "3) Computer VS Computer"));
  }

  @Test
  public void quitGame() {
    run("1\n3\n2\n");
    assertThat(
        out.toString(),
        containsString(
            "Play again?"
                + System.lineSeparator()
                + "1) Yes"
                + System.lineSeparator()
                + "2) No"
                + System.lineSeparator()
                + "Exiting"));
  }

  @Test
  public void humanVShuman() {
    run("1\n1\n1\n5\n3\n9\n2\n2\n");
    assertThat(out.toString(), containsString("X is the winner"));
  }

  @Test
  public void humanVShumanInvalidSelection() {
    run("1\n1\n1\n5\n3\n9\n9\n2\n2\n");
    assertThat(out.toString(), containsString("Select a Valid Number"));
  }

  @Test
  public void humanVShumanTiedGame() {
    run("1\n1\n1\n5\n3\n2\n8\n4\n6\n9\n7\n2\n");
    assertThat(out.toString(), containsString("Game tied"));
  }

  @Test
  public void computerVScomputer() {
    run("1\n3\n2");
    assertThat(out.toString(), containsString("Exiting"));
  }

  @Test
  public void humanVScomputerHumanFirst() {
    run("1\n2\n1\n6\n7\n8\n1\n1\n3\n2\n");
    assertThat(
        out.toString(),
        containsString(
            "Who plays first?"
                + System.lineSeparator()
                + "1) Human"
                + System.lineSeparator()
                + "2) Computer"));
  }

  @Test
  public void humanVScomputerComputerFirst() {
    run("1\n2\n2\n9\n8\n2\n");
    assertThat(out.toString(), containsString("Exiting"));
  }

  @Test
  public void invalidSelection() {
    run("10\n1\n3\n2\n");
    assertThat(out.toString(), containsString("Select a Valid Number"));
  }

  @Test
  public void stringSelected() {
    run("dan\n1\n3\n2\n");
    assertThat(out.toString(), containsString("Select a Valid Number"));
  }
}
