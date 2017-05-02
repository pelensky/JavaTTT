package com.pelensky.tictactoe;

class AppRunner {

    private IO io;

    AppRunner(IO io){
        this.io = io;
    }

    void run(){
        io.print("Tic Tac Toe");
    }
}
