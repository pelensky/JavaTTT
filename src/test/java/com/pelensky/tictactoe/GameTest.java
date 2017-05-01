package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void player1StartsTheGame() {
        assertEquals(player1, game.currentPlayer);
    }

    @Test
    public void currentPlayerChangesAfterTurn() {
        game.takeTurn(0);
        assertEquals(player2, game.currentPlayer);
    }

    @Test(expected = IllegalMoveException.class)
    public void doesNotChangeCurrentPlayerAfterIllegalMove() {
        game.takeTurn(1);
        game.takeTurn(1);
        assertEquals(player2, game.currentPlayer);
    }


}
