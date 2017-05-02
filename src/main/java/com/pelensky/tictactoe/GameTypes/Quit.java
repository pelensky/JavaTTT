package com.pelensky.tictactoe.GameTypes;

public class Quit implements GameType {
    @Override
    public void execute() {

    }

    @Override
    public String instruction() {
        return "Quit";
    }
}
