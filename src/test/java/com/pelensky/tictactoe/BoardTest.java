package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BoardTest {

  private Board board;

  @Before
  public void setUp() {
    board = new Board(3);
  }

  @Test
  public void boardInitializesWithNineSpaces() {
    assertEquals(9, board.getSpaces().size());
  }

  @Test
  public void allSpacesAreAvailableWhenBoardIsInitialized() {
    assertEquals(9, board.getAvailableSpaces().size());
  }

  @Test
  public void getAvailableSpacesReturnsZeroWhenFull() {
    board.spaces = new ArrayList<>(Arrays.asList("O", "X", "O", "X", "O", "X", "X", "O", "X"));
    assertEquals(0, board.getAvailableSpaces().size());
  }

  @Test
  public void takeTurn() {
    board.placeMarker(0, "X");
    assertEquals("X", board.getSpaces().get(0));
  }

  @Test
  public void cantChooseSomewhereOutsideBoard() {
    assertFalse(board.isMarkerAllowed(10));
  }

  @Test
  public void cantChooseSomewhereTaken() {
    board.placeMarker(2, "0");
    assertFalse(board.isMarkerAllowed(2));
  }
}
