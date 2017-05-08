package com.pelensky.tictactoe;

import com.pelensky.tictactoe.App.Input;
import com.pelensky.tictactoe.App.UI;
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
    UI ui = new UI(new PrintStream(System.out));
    Input input = new Input(new Scanner(System.in), ui);
    human = new HumanPlayer(input, ui,  "X");
  }

  @Test
  public void markerIsStored() {
    assertEquals("X", human.getMarker());
  }
}
