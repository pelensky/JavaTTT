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
    private Board board;
    private Board bigBoard;

    @Before
    public void setUp(){
        out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        print = new Print(output);
        board = new Fake3X3Board(3);
        bigBoard = new Fake4X4Board(4);
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
        print.board(bigBoard);
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
