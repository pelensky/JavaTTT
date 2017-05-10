package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.ComputerPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComputerPlayerTest {

  private MockRandom mockRandom;
  private ComputerPlayer computer;
  private Board board;

  @Before
  public void setUp() {
    mockRandom = new MockRandom();
    computer = new ComputerPlayer("O", mockRandom);
    board = new Board(3);
  }

  @Test
  public void markerIsStored() {
    assertEquals("O", computer.getMarker());
  }

  @Test
  public void computerSelectsASpot() {
    computer.getMove(board);
    assertTrue(mockRandom.getHasComputerPlayed());
  }
}
