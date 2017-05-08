package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.Commands.*;
import com.pelensky.tictactoe.Game;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private final List<Command> commands;
    private Game game;
    private Input input;
    private Print print;
    private boolean appRunning = true;

    public AppRunner(Input input, Print print, List<Command> commands) {
        this.input = input;
        this.print = print;
        this.commands = commands;
    }

    public void run() {
        while (appRunning) {
            startGame();
            if (game != null) {
                while (gameInProgress()) {
                    makeMove();
                }
                endOfGame();
            }
        }
    }

    public void quitApp() {
        appRunning = false;
        print.exiting();
    }

    private void startGame() {
        print.welcome();
        print.options(commands);
        int selection = input.getInteger();
        if (isSelectionValid(selection, commands)) {
            game = startNewGame(selection);
        } else {
            print.invalidSelection();
        }
    }

    private boolean isSelectionValid(int selection, List<Command> options) {
        return (selection <= options.size() && selection > 0);
    }

    private Game startNewGame(int choice) {
        Command newGame = commands.get(choice - 1);
        return newGame.execute();
    }

    private boolean gameInProgress() {
        return !game.isGameOver();
    }

    private void makeMove() {
        print.selectSpace(game);
        print.board(game);
        game.takeTurn();
    }

    private void endOfGame() {
        print.outcome(game);
        print.board(game);
        playAgain();
    }

    private void playAgain() {
        print.playAgain();
        print.options(playCommands());
        int selection = input.getInteger();
        if (isSelectionValid(selection, playCommands())) {
            playAgainCommand(selection);
        }
    }

    private void playAgainCommand(int selection) {
        Command playOrQuit = playCommands().get(selection - 1);
        playOrQuit.execute();
    }

    private List<Command> playCommands() {
        return Arrays.asList(new PlayAgain(), new Quit(this));
    }
}