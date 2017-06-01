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


}
