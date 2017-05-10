package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Commands.*;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private final List<Command> commands;
    private Game game;
    private Input input;
    private Print print;
    private boolean appRunning = true;

    AppRunner(Input input, Print print, List<Command> commands) {
        this.input = input;
        this.print = print;
        this.commands = commands;
    }

    void run() {
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
        print.clearScreen();
        print.welcome();
        game = startNewGame(validSelectionLoop(commands));
    }


    private int validSelectionLoop(List<Command> options) {
        print.options(options);
        int selection = -1;
        while (selection < 0){
            int proposedSelection = input.getInteger();
            if (isSelectionValid(proposedSelection, options)) {
                selection = proposedSelection;
            } else {
                print.invalidSelection();
            }
        } return selection;
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
        print.clearScreen();
        print.selectSpace(game);
        print.board(game);
        game.takeTurn();
    }

    private void endOfGame() {
        print.clearScreen();
        print.outcome(game);
        print.board(game);
        playAgain();
    }

    private void playAgain() {
        print.playAgain();
        playAgainCommand(validSelectionLoop(playCommands()));

    }

    private void playAgainCommand(int selection) {
        Command playOrQuit = playCommands().get(selection - 1);
        playOrQuit.execute();
    }

    private List<Command> playCommands() {
        return Arrays.asList(new PlayAgain(), new Quit(this));
    }
}