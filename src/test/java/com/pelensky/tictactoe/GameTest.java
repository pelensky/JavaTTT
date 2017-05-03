package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.HumanPlayer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void checkForWinHorizontalA() {
        board.spaces = new ArrayList<>(Arrays.asList("X", "X", "X", "3", "4", "5", "6", "7", "8"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinHorizontalB() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "2", "O", "O", "O", "6", "7", "8"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinHorizontalC() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "X", "X", "X"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalA() {
        board.spaces = new ArrayList<>(Arrays.asList("O", "1", "2", "O", "4", "5", "O", "7", "8"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalB() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "X", "2", "3", "X", "5", "6", "X", "8"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalC() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "O", "3", "4", "O", "6", "7", "O"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinLeftDiagonal() {
        board.spaces = new ArrayList<>(Arrays.asList("X", "1", "2", "3", "X", "5", "6", "7", "X"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinRightDiagonal() {
        board.spaces = new ArrayList<>(Arrays.asList("0", "1", "O", "3", "O", "5", "O", "7", "8"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkGameNotWon() {
        board.spaces = new ArrayList<>(Arrays.asList("X", "1", "2", "3", "O", "5", "O", "7", "8"));
        assertFalse(game.isGameOver());
    }

    @Test
    public void isGameTied() {
        board.spaces = new ArrayList<>(Arrays.asList("O", "X", "O", "X", "O", "X", "X", "O", "X"));
        assertTrue(game.isGameOver());
    }

}
