package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.RandomComputerPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomComputerPlayerTest {

  private FakeRandom fakeRandom;
  private RandomComputerPlayer player2;
  private Game game;

  @Before
  public void setUp() {
    fakeRandom = new FakeRandom();
    RandomComputerPlayer player1 = new RandomComputerPlayer("X", fakeRandom);
    player2 = new RandomComputerPlayer("O", fakeRandom);
    Board board = new Board(3);
    game = new Game(board, player1, player2);
  }

  @Test
  public void markerIsStored() {
    assertEquals("O", player2.getMarker());
  }

  @Test
  public void computerSelectsASpot() {
    player2.getMove(game);
    assertTrue(fakeRandom.getHasComputerPlayed());
  }
}
