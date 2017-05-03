package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.HumanPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private HumanPlayer human;

    @Before
    public void setUp(){
        human = new HumanPlayer("X");
    }

    @Test
    public void  markerIsStored(){
     assertEquals("X", human.getMarker());
    }

}
