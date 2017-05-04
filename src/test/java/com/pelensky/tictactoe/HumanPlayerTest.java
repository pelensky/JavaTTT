package com.pelensky.tictactoe;

import com.pelensky.tictactoe.App.IO;
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
    IO io = new IO(new Scanner(System.in), new PrintStream(System.out));
    human = new HumanPlayer(io, "X");
  }

  @Test
  public void markerIsStored() {
    assertEquals("X", human.getMarker());
  }
}
