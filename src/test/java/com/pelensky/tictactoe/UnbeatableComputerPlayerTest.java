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
        setUpBoard("1O2O3X4X5X6O7O8X");
        assertEquals(computer.getMove(board), 9);
    }

    private void setUpBoard(String move) {
        for (int turn = 0; turn < move.length(); turn += 2) {
            Integer space = Character.getNumericValue(move.charAt(turn));
            String marker = String.valueOf(move.charAt(turn + 1));
            board.placeMarker(space, marker);
        }
    }


}
