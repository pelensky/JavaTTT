package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.Commands.*;
import com.pelensky.tictactoe.Game;

import java.util.Arrays;
import java.util.List;

public class AppRunner extends Input {

    private final List<Command> commands;
    private Game game;
    private UI ui;
    private boolean appRunning = true;

    public AppRunner(IO io, UI ui, List<Command> commands) {
        super(io);
        this.commands = commands;
        this.ui = ui;
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
        ui.printExiting();
    }

    private void startGame() {
        ui.printWelcome();
        ui.printOptions(commands);
        int selection = getInteger();
        if (isSelectionValid(selection, commands)) {
            game = startNewGame(selection);
        } else {
            ui.printInvalidSelection();
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
        ui.printSelectSpace(game);
        ui.printBoard(game);
        game.takeTurn();
    }

    private void endOfGame() {
        ui.printOutcome(game);
        ui.printBoard(game);
        playAgain();
    }

    private void playAgain() {
        ui.printPlayAgain();
        ui.printOptions(playCommands());
        int selection = getInteger();
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