package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Players.HumanPlayer;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private HumanPlayer player1;
    private HumanPlayer player2;
    private Board board;
    private Game game;
    private Board bigBoard;
    private Game bigGame;

    @Before
    public void setUp() {
        Print print = new Print(new PrintStream(System.out));
        Input input = new Input(new Scanner(System.in), print);
        player1 = new HumanPlayer(input, "X");
        player2 = new HumanPlayer(input, "O");
        board = new Board(3);
        bigBoard = new Board(4);
    }

    private void setSpacesAndCreateGame(List<String> strings) {
        board.spaces = new ArrayList<>(strings);
        game = new Game(board, player1, player2);
    }

    private void setSpacesAndCreateBigGame(List<String> strings) {
        bigBoard.spaces = new ArrayList<>(strings);
        bigGame = new Game(bigBoard, player1, player2);
    }

    @Test
    public void gameAcceptsTwoPlayersAndABoard() {
        game = new Game(board, player1, player2);
        assertEquals(player1, game.player1);
        assertEquals(player2, game.player2);
        assertEquals(board, game.board);
    }

    @Test
    public void player1StartsTheGame() {
        game = new Game(board, player1, player2);
        assertEquals(player1, game.currentPlayer);
    }

    @Test
    public void checkForWinHorizontalA() {
        setSpacesAndCreateGame(Arrays.asList("X", "X", "X", "4", "5", "6", "7", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinHorizontalB() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "3", "O", "O", "O", "7", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinHorizontalC() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "3", "4", "5", "6", "X", "X", "X"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalA() {
        setSpacesAndCreateGame(Arrays.asList("O", "2", "3", "O", "5", "6", "O", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalB() {
        setSpacesAndCreateGame(Arrays.asList("1", "X", "3", "4", "X", "6", "7", "X", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalC() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "O", "4", "5", "O", "7", "8", "O"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinLeftDiagonal() {
        setSpacesAndCreateGame(Arrays.asList("X", "2", "3", "4", "X", "6", "7", "8", "X"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinRightDiagonal() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "O", "4", "O", "6", "O", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkGameNotWon() {
        setSpacesAndCreateGame(Arrays.asList("X", "2", "3", "4", "O", "6", "O", "8", "9"));
        assertFalse(game.isGameOver());
    }

    @Test
    public void isGameTied() {
        setSpacesAndCreateGame(Arrays.asList("O", "X", "O", "X", "O", "X", "X", "O", "X"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinHorizontalBig() {
        setSpacesAndCreateBigGame(Arrays.asList("X", "X", "X", "X", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"));
        assertTrue(bigGame.isGameOver());
    }


    @Test
    public void checkForWinVerticalBig() {
        setSpacesAndCreateBigGame(Arrays.asList("O", "2", "3", "4", "O", "6", "7", "8", "O", "10", "11", "12", "O", "14", "15", "16"));
        assertTrue(bigGame.isGameOver());
    }

    @Test
    public void checkForWinLeftDiagonalBig() {
        setSpacesAndCreateBigGame(Arrays.asList("X", "2", "3", "4", "5", "X", "7", "8", "9", "10", "X", "12", "13", "14", "15", "X"));
        assertTrue(bigGame.isGameOver());
    }

    @Test
    public void checkForWinRightDiagonalBig() {
        setSpacesAndCreateBigGame(Arrays.asList("1", "2", "3", "O", "5", "6", "O", "8", "9", "O", "11", "12", "O", "14", "15", "16"));
        assertTrue(bigGame.isGameOver());
    }


}
