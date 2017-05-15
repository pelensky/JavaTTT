package com.pelensky.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    private ByteArrayOutputStream out;
    private Print print;
    private Game game;
    private Game bigGame;
    private Board board;

    @Before
    public void setUp(){
//        Input input = new Input(new Scanner(System.in), print);
        out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        print = new Print(output);
//        final Board board = new Board(3);
//        final Board bigBoard = new Board(4);
//        final Player player1 = new HumanPlayer(input, "X");
//        final Player player2 = new HumanPlayer(input, "O");
//        game = new Game(board, player1, player2);
//        bigGame = new Game(bigBoard, player1, player2);
        board = new Fake3X3Board(3);
    }

    @Test
    public void printBoard(){
        print.board(board);
        assertThat(
                out.toString(),
                containsString(" 1 | 2 | 3" + System.lineSeparator() +
                        "---------------" + System.lineSeparator() +
                        " 4 | 5 | 6" + System.lineSeparator() +
                        "---------------" + System.lineSeparator() +
                        " 7 | 8 | 9" ));
    }

    @Test
    public void printBigBoard(){
        print.board(board);
        assertThat(
                out.toString(),
                containsString(" 1 | 2 | 3 | 4" + System.lineSeparator() +
                        "---------------" + System.lineSeparator() +
                        " 5 | 6 | 7 | 8" + System.lineSeparator() +
                        "---------------" + System.lineSeparator() +
                        " 9 | 10 | 11 | 12" + System.lineSeparator() +
                        "---------------" + System.lineSeparator() +
                        " 13 | 14 | 15 | 16"));
    }
}
