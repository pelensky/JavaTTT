package com.pelensky.tictactoe.App;

import com.pelensky.tictactoe.Players.ComputerPlayer;
import com.pelensky.tictactoe.Game;
import com.pelensky.tictactoe.GameTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AppRunner {

    private IO io;
    private boolean appRunning;
    private Game game;
    private Random random;

    public AppRunner(IO io, Random random) {
        this.io = io;
        this.random = random;
        this.appRunning = true;
    }

    public void run() {
        while (appRunning) {
            startGame();
            if (game != null) {
                while (gameInProgress()) {
                    gameLoop();
                }
                endOfGame();
            }
        }
    }

    public void quitApp() {
        this.appRunning = false;
        io.print("Exiting");
    }

    private void startGame() {
        io.print(welcome());
        io.print(instructions());
        int selection = select();
        if (isValidSelection(selection)) {
            game = startNewGame(selection);
        } else {
            io.print("Invalid selection");
        }
    }

    private String welcome() {
        return "Tic Tac Toe" + System.lineSeparator() + "Select Game Type";
    }

    private String instructions() {
        StringBuilder instructions = new StringBuilder();
        for (int i = 0; i < gameTypes().size(); i++) {
            instructions.append(i + 1).append(") ").append(gameTypes().get(i).instruction()).append(System.lineSeparator());
        }
        return instructions.toString().trim();
    }

    private List<GameType> gameTypes() {
        return Arrays.asList(
                new HumanVSHuman(),
                new HumanVSComputer(io, random),
                new ComputerVSComputer(),
                new Quit(this));
    }

    private boolean isValidSelection(int selection) {
        return (selection <= gameTypes().size() && selection > 0);
    }

    private Game startNewGame(int choice) {
        GameType newGame = gameTypes().get(choice - 1);
        return newGame.execute();
    }

    private boolean gameInProgress() {
        return !game.isGameOver();
    }

    private void gameLoop() {
        io.print(game.currentPlayer.getMarker() + " select a space");
        io.print(showBoard());
        if (game.currentPlayer instanceof ComputerPlayer) {
            computerTurn();
        } else {
            humanTurn();
        }
    }

    private void computerTurn() {
        game.takeTurn(((ComputerPlayer) game.currentPlayer).selectRandomAvailableSpace(game.board));
    }

    private void humanTurn() {
        int proposedSpace = Integer.valueOf(io.getInput());
        if (game.isMoveAllowed(proposedSpace)) {
            game.takeTurn(proposedSpace);
        } else {
            io.print("Try again");
        }
    }

    private void endOfGame() {
        printOutcome();
        io.print(showBoard());
        io.print("-----------------------");
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