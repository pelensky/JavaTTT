package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.Commands.*;
import com.pelensky.tictactoe.Game;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private IO io;
    private List<Command> commands;
    private boolean appRunning = true;
    private Game game;


    public AppRunner(IO io, List<Command> commands) {
        this.io = io;
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
        io.print("Exiting");
    }

    private void startGame() {
        io.print(welcome());
        io.print(instructions(commands));
        int selection = select();
        if (isSelectionValid(selection, commands)) {
            game = startNewGame(selection);
        } else {
            io.print("Invalid selection");
        }
    }

    private String welcome() {
        return "Tic Tac Toe" + System.lineSeparator() + "Select Game Type";
    }

    private String instructions(List<Command> options) {
        StringBuilder instructions = new StringBuilder();
        for (int i = 0; i < options.size(); i++) {
            instructions.append(i + 1).append(") ").append(options.get(i).instruction()).append(System.lineSeparator());
        }
        return instructions.toString().trim();
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
        io.print(getCurrentPlayerMarker() + " select a space");
        io.print(showBoard());
        game.takeTurn();
    }

    private String getCurrentPlayerMarker() {
        return game.currentPlayer.getMarker();
    }

    private void endOfGame() {
        printOutcome();
        io.print(showBoard());
        playAgain();
    }

    private void playAgain() {
        io.print("Play again?");
        io.print((instructions(playCommands())));
        int selection = select();
        if (isSelectionValid(selection, playCommands())) {
            playAgainCommand(selection);
        } else {
            io.print("Invalid selection");
        }
    }

    private void playAgainCommand(int selection) {
        Command playOrQuit = playCommands().get(selection - 1);
        playOrQuit.execute();
    }

    private List<Command> playCommands() {
        return Arrays.asList(
                new PlayAgain(),
                new Quit(this));
    }

    private void printOutcome() {
        if (game.getWinner() != null) {
            io.print(game.getWinner().getMarker() + " is the winner");
        } else {
            io.print("Game tied");
        }
    }

    private String showBoard() {
        String line = System.lineSeparator() + "-----------" + System.lineSeparator();
        return getRow(0, 1, 2) + line + getRow(3, 4, 5) + line + getRow(6, 7, 8) + System.lineSeparator();
    }

    private String getRow(int a, int b, int c) {
        return " " + getSpace(a) + " | " + getSpace(b) + " | " + getSpace(c);
    }

    private String getSpace(int index) {
        return game.getSpaces().get(index);
    }

    private int select() {
        return Integer.parseInt(io.getInput());
    }
}