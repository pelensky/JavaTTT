package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private HumanPlayer player1;
    private HumanPlayer player2;
    private Board board;
    private Game game;

    @Before
    public void setUp() {
        player1 = new HumanPlayer("X");
        player2 = new HumanPlayer("O");
        board = new Board(3);
        game = new Game(board, player1, player2);
    }

    @Test
    public void gameAcceptsTwoPlayersAndABoard() {
        assertEquals(player1, game.player1);
        assertEquals(player2, game.player2);
        assertEquals(board, game.board);
    }


}
