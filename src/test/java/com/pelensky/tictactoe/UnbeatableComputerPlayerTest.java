package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.Player;
import com.pelensky.tictactoe.Players.UnbeatableComputerPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnbeatableComputerPlayerTest {
    private UnbeatableComputerPlayer player1;
    private UnbeatableComputerPlayer player2;
    private Board board;
    private Game game;
    private Player human;

    @Before
    public void setUp() {
        player1 = new UnbeatableComputerPlayer("X");
        player2 = new UnbeatableComputerPlayer("O");
        board = new Board(3);
        game = new Game(board, player1, player2);
    }


    @Test
    public void markerIsStored() {
        assertEquals("X", player1.getMarker());
    }

    @Test
    public void computerPlaysInOnlyAvailableSpace() {
        setUpBoard("1O2O3X4X5X6O7O8X");
        assertEquals(player2.getMove(game), 9);
    }

//    @Test
//    public void computerWinsGameIfItGetsTheOpportunity() {
//        setUpBoard("1X4O5O7X8X");
//        assertEquals(player2.getMove(game), 6);
//    }

    private void setUpBoard(String move) {
        for (int turn = 0; turn < move.length(); turn += 2) {
            Integer space = Character.getNumericValue(move.charAt(turn));
            String marker = String.valueOf(move.charAt(turn + 1));
            board.placeMarker(space, marker);
        }
    }


}
