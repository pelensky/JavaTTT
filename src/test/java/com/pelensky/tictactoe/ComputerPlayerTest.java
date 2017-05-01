package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {

    private ComputerPlayer computer;
    private Board board;

    @Before
    public void setUp() {
        computer = new ComputerPlayer("O");
        board = new Board(3);
    }

    @Test
    public void markerIsStored() {
        assertEquals("O", computer.getMarker());
    }

    @Test
    public void userTakesTurn() {
        computer.takeTurn(board, 3);
        assertEquals("O", board.getSpaces().get(3));
    }

    @Test
    public void computerSelectsOnlyAvailableSpot() {
        board.spaces = new ArrayList<>(Arrays.asList("O", "X", "O", "X", "4", "X", "X", "O", "X"));
        assertEquals(4, computer.selectRandomAvailableSpace(board));
    }
}
