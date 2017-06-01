package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.UnbeatableComputerPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnbeatableComputerPlayerTest {
    private UnbeatableComputerPlayer computer;
    private Board board;

    @Before
    public void setUp() {
        computer = new UnbeatableComputerPlayer("O");
        board = new Board(3);
    }


    @Test
    public void markerIsStored() {
        assertEquals("O", computer.getMarker());
    }

    @Test
    public void computerPlaysInOnlyAvailableSpace() {
        lastMove();
        assertEquals(computer.getMove(board), 9);

    }

    private void lastMove() {
        board.placeMarker(1, "O");
        board.placeMarker(2, "O");
        board.placeMarker(3, "X");
        board.placeMarker(4, "X");
        board.placeMarker(5, "X");
        board.placeMarker(6, "O");
        board.placeMarker(7, "O");
        board.placeMarker(8, "X");

    }


}
