package com.pelensky.tictactoe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class InputTest {
    private Input input;


    public void setUp(String text){
        Scanner scanner = new Scanner(text);
        Print print = new Print(new PrintStream(new ByteArrayOutputStream()));
        input = new Input(scanner, print);
    }

    @Test
    public void integerIsGivenWhenOne(){
        setUp("1\n");
        assertEquals(1, input.getInteger());
    }

    @Test
    public void integerIsGivenWhenTwo(){
        setUp("2\n");
        assertEquals(2, input.getInteger());
    }

    @Test
    public void wontReturnUntilValidInteger(){
        setUp("dan\n2\n");
        assertEquals(2, input.getInteger());
    }
}
