package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

class Fake3X3Board extends Board {
    Fake3X3Board(int numberOfRows){
        super(numberOfRows);
    }
    ArrayList<ArrayList<String>> getRows() {
        ArrayList<String> one = new ArrayList<>(Arrays.asList("1", "2", "3"));
        ArrayList<String> two = new ArrayList<>(Arrays.asList("4", "5", "6"));
        ArrayList<String> three = new ArrayList<>(Arrays.asList("7", "8", "9"));
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        board.add(one);
        board.add(two);
        board.add(three);
        return board;
    }
}
