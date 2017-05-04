package com.pelensky.tictactoe.Commands;

import com.pelensky.tictactoe.App.AppRunner;
import com.pelensky.tictactoe.Game;

public class PlayAgain implements Command {
    private AppRunner appRunner;

    public PlayAgain(AppRunner appRunner){
        this.appRunner = appRunner;
    }

    @Override
    public Game execute() {
        return null;
    }

    @Override
    public String instruction() {
        return "Yes";
    }
}
