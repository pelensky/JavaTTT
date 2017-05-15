package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

class Fake4X4Board extends Board {
    Fake4X4Board(int numberOfRows){
        super(numberOfRows);
    }
    ArrayList<ArrayList<String>> getRows() {
        ArrayList<String> one = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        ArrayList<String> two = new ArrayList<>(Arrays.asList("5", "6", "7", "8"));
        ArrayList<String> three = new ArrayList<>(Arrays.asList("9", "10", "11", "12"));
        ArrayList<String> four = new ArrayList<>(Arrays.asList("13", "14", "15", "16"));
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        board.add(one);
        board.add(two);
        board.add(three);
        board.add(four);
        return board;
    }
}
