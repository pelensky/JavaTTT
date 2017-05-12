package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.ComputerPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComputerPlayerTest {

  private FakeRandom fakeRandom;
  private ComputerPlayer computer;
  private Board board;

  @Before
  public void setUp() {
    fakeRandom = new FakeRandom();
    computer = new ComputerPlayer("O", fakeRandom);
    board = new Board(3);
  }

  @Test
  public void markerIsStored() {
    assertEquals("O", computer.getMarker());
  }

  @Test
  public void computerSelectsASpot() {
    computer.getMove(board);
    assertTrue(fakeRandom.getHasComputerPlayed());
  }
}
