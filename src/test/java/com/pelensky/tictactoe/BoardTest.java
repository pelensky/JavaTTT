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
//    @Test
//    public void checkForWinHorizontal() {
//        board.spaces = new ArrayList<>(Arrays.asList("X", "X", "X", "3", "4", "5", "6", "7", "8"));
//        assertTrue(board.isGameOver());
//    }
//
//    @Test
//    public void checkHorizontal() {
//        assertEquals("Dan", board.isGameOver());
//    }

}
