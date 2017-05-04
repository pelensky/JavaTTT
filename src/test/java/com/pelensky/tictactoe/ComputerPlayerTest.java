package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.ComputerPlayer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ComputerPlayerTest {

    private ComputerPlayer computer;
    private Board board;

    @Before
    public void setUp() {
        computer = new ComputerPlayer("O", new Random());
        board = new Board(3);
    }

    @Test
    public void markerIsStored() {
        assertEquals("O", computer.getMarker());
    }

    @Test
    public void computerSelectsASpot() {
       assertThat(computer.getMove(9), instanceOf(Integer.class));
    }
}
