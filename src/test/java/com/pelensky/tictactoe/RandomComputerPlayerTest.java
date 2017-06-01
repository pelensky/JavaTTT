package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.RandomComputerPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomComputerPlayerTest {

  private FakeRandom fakeRandom;
  private RandomComputerPlayer computer;
  private Board board;

  @Before
  public void setUp() {
    fakeRandom = new FakeRandom();
    computer = new RandomComputerPlayer("O", fakeRandom);
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
