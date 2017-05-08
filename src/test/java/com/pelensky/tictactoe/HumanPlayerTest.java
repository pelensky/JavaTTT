package com.pelensky.tictactoe;

import com.pelensky.tictactoe.App.Input;
import com.pelensky.tictactoe.App.Print;
import com.pelensky.tictactoe.Players.HumanPlayer;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

  private HumanPlayer human;

  @Before
  public void setUp() {
    Print print = new Print(new PrintStream(System.out));
    Input input = new Input(new Scanner(System.in), print);
    human = new HumanPlayer(input,  "X");
  }

  @Test
  public void markerIsStored() {
    assertEquals("X", human.getMarker());
  }
}
