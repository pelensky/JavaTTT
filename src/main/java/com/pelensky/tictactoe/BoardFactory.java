package com.pelensky.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BoardFactory {

    Board board;

    Board createBoard(int size){
        if (size == 1){
            board = new Board(3);
        } else if (size == 2){
            board = new Board(4);
        } else {
            return createBoard(size);
        }
        return board;
    }

    List<String> boardTypes() {
        return Arrays.asList(
                "Normal (3x3)", "Large (4x4)");
    }

    List<Integer> boardTypesCount() {
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < boardTypes().size(); i++){
            count.add(i + 1);
        }
        return count;
    }

}
