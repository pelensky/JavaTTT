package com.pelensky.tictactoe.PlayAgainOptions;

import com.pelensky.tictactoe.AppRunner;

public class Quit implements Options {

    private final AppRunner appRunner;

    public Quit(AppRunner appRunner) {
        this.appRunner = appRunner;
    }

    @Override
    public void execute() {
        appRunner.quitApp();
    }

    @Override
    public String title() {
        return "No";
    }
}
