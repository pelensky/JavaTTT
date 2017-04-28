package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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




}
