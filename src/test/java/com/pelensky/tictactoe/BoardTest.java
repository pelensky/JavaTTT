package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void checkForWinHorizontalA() {
        board.spaces = new ArrayList<>(Arrays.asList("X", "X", "X", "3", "4", "5", "6", "7", "8"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkForWinHorizontalB() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "2", "O", "O", "O", "6", "7", "8"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkForWinHorizontalC() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "X", "X", "X"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkForWinVerticalA() {
        board.spaces = new ArrayList<>(Arrays.asList("O", "1", "2", "O", "4", "5", "O", "7", "8"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkForWinVerticalB() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "X", "2", "3", "X", "5", "6", "X", "8"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkForWinVerticalC() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "O", "3", "4", "O", "6", "7", "O"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkForWinLeftDiagonal() {
        board.spaces = new ArrayList<>(Arrays.asList("X", "1", "2", "3", "X", "5", "6", "7", "X"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkForWinRightDiagonal() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "O", "3", "O", "5", "O", "7", "8"));
        assertTrue(board.isGameOver());
    }

    @Test
    public void checkGameNotWon() {
        board.spaces = new ArrayList<>(Arrays.asList("X", "1", "2", "3", "O", "5", "O", "7", "8"));
        assertFalse(board.isGameOver());
    }

    @Test
    public void isGameTied() {
        board.spaces = new ArrayList<>(Arrays.asList("O", "X", "O", "X", "O", "X", "X", "O", "X"));
        assertTrue(board.isGameOver());
    }




}
