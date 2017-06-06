package com.pelensky.tictactoe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class InputTest {
    private Input input;
    private List<Integer> list;


    public void setUp(String text){
        Scanner scanner = new Scanner(text);
        Print print = new Print(new PrintStream(new ByteArrayOutputStream()));
        list = Arrays.asList(1,3,5);
        input = new Input(scanner, print);
    }

    @Test
    public void selectionIsValidWhenItExists(){
        setUp("1\n");
        assertEquals(1, input.validateSelection(list));
    }

    @Test
    public void selectionInvalidWhenNotOnList(){
        setUp("2\n1\n");
        assertEquals(1, input.validateSelection(list));
    }

    @Test
    public void wontReturnUntilValidInteger(){
        setUp("dan\n1\n");
        assertEquals(1, input.validateSelection(list));
    }
}
