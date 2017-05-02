package com.pelensky.tictactoe;

import com.pelensky.tictactoe.GameTypes.*;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private IO io;
    private boolean appRunning;
    private Game game;

    public AppRunner(IO io) {
        this.io = io;
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

    private String showBoard() {
        String betweenSpaces = " | ";
        String line = "-----------";
        String offset = " ";
        return offset + getSpace(0) + betweenSpaces + getSpace(1) + betweenSpaces + getSpace(2) +
                System.lineSeparator() + line + System.lineSeparator() +
                offset + getSpace(3) + betweenSpaces + getSpace(4) + betweenSpaces + getSpace(5) +
                System.lineSeparator() + line + System.lineSeparator() +
                offset + getSpace(6) + betweenSpaces + getSpace(7) + betweenSpaces + getSpace(8);
    }

    private String getSpace(int index) {
        return game.getSpaces().get(index);
    }

    private boolean gameInProgress() {
        return !game.isGameOver();
    }

    private List<GameType> gameTypes() {
        return Arrays.asList(
                new HumanVSHuman(),
                new HumanVSComputer(),
                new ComputerVSComputer(),
                new Quit(this));
    }

    private String instructions() {
        StringBuilder instructions = new StringBuilder();
        for (int i = 0; i < gameTypes().size(); i++) {
            instructions.append(i + 1).append(") ").append(gameTypes().get(i).instruction()).append(System.lineSeparator());
        }
        return instructions.toString().trim();
    }

    private int select() {
        return Integer.parseInt(io.getInput());
    }

    private void startGame() {
        io.print(welcome());
        io.print(instructions());
        game = startNewGame(select());
    }

    private void gameLoop() {
        io.print(game.currentPlayer.getMarker() + " select a space");
        io.print(showBoard());
        if (game.currentPlayer instanceof ComputerPlayer) {
            game.takeTurn(((ComputerPlayer) game.currentPlayer).selectRandomAvailableSpace(game.board));
        } else {
            game.takeTurn(Integer.valueOf(io.getInput()));
        }
    }

    private void endOfGame() {
        if (game.getWinner() != null) {
            io.print(game.getWinner().getMarker() + " is the winner");
        } else {
            io.print("Game tied");
        }
        io.print(showBoard());
        io.print("-----------------------");
    }

    private Game startNewGame(int choice) {
        GameType newGame = gameTypes().get(choice - 1);
        return newGame.execute();
    }

    private String welcome() {
        return "Tic Tac Toe" + System.lineSeparator() + "Select Game Type";
    }

    public void quitApp() {
        this.appRunning = false;
        io.print("Exiting");
    }
}
