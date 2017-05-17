package com.pelensky.tictactoe;

class BoardFactory {

    Board board;

    Board createBoard(int size){
        if (size == 3){
            board = new Board(3);
        } else if (size == 4){
            board = new Board(4);
        } else {
            return createBoard(size);
        }
        return board;
    }
}
