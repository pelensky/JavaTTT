package com.pelensky.tictactoe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    AppRunner appRunner = new AppRunner(input, print, new BoardFactory(), new GameFactory(input, new FakeRandom()));
    appRunner.run();
  }

  @Test
  public void welcomesUser() {
    run("2\n4\n2\n");
    assertThat(
        out.toString(),
        containsString("Tic Tac Toe" + System.lineSeparator() + "Select Board Size" ));
  }

  @Test
  public void selectsBoardSize(){
    run("1\n4\n2\n");
    assertThat(
            out.toString(),
            containsString("Select Game Type"));
  }


  @Test
  public void selectGameType() {
    run("1\n4\n1\n2\n4\n2\n");
    assertThat(
        out.toString(),
        containsString(
            "1) Human vs Human"));
  }

  @Test
  public void quitGame() {
    run("1\n4\n1\n1\n4\n2\n");
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
    run("1\n4\n2");
    assertThat(out.toString(), containsString("Exiting"));
  }

  @Test
  public void humanVScomputerComputerFirst() {
    run("1\n3\n9\n8\n2\n");
    assertThat(out.toString(), containsString("Exiting"));
  }

  @Test
  public void invalidSelection() {
    run("10\n1\n4\n2\n");
    assertThat(out.toString(), containsString("Select a Valid Number"));
  }

  @Test
  public void stringSelected() {
    run("dan\n1\n4\n2\n");
    assertThat(out.toString(), containsString("Select a Valid Number"));
  }
}
