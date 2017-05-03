package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.HumanPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private HumanPlayer human;
    private Board board;

    @Before
    public void setUp(){
        human = new HumanPlayer("X");
        board = new Board(3);
    }

    @Test
    public void  markerIsStored(){
     assertEquals("X", human.getMarker());
    }

}
