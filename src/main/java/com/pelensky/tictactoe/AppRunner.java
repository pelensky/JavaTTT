package com.pelensky.tictactoe;

import com.pelensky.tictactoe.PlayAgainOptions.Options;
import com.pelensky.tictactoe.PlayAgainOptions.PlayAgain;
import com.pelensky.tictactoe.PlayAgainOptions.Quit;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private Game game;
    private Input input;
    private Print print;
    private BoardFactory boardFactory;
    private GameFactory gameFactory;
    private boolean appRunning = true;

    AppRunner(Input input, Print print, BoardFactory boardFactory, GameFactory gameFactory) {
        this.input = input;
        this.print = print;
        this.boardFactory = boardFactory;
        this.gameFactory = gameFactory;
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

    private void startGame() {
        print.clearScreen();
        print.welcome();
        Board board = createBoard();
        game = createGame(board);
    }

    private Game createGame(Board board) {
        print.gameType();
        print.optionsNew(gameFactory.gameTypes());
        return gameFactory.createGame(getSelectionNew(gameFactory.gameTypes()), board);
    }

    private Board createBoard() {
        print.selectBoard();
        print.optionsNew(boardFactory.boardTypes());
        return boardFactory.createBoard(getSelectionNew(boardFactory.boardTypes()));
    }


    private int getSelection(List<? extends Menu> options) {
        return input.validateSelection(input.validSelections(options));
    }

    private int getSelectionNew(List<String> options) {
        return input.validateSelection(input.optionCount(options));
    }

    private boolean gameInProgress() {
        return !game.isGameOver();
    }

    private void makeMove() {
        print.clearScreen();
        print.selectSpace(game);
        print.board(game.board);
        game.takeTurn();
    }

    private void endOfGame() {
        print.clearScreen();
        print.outcome(game);
        print.board(game.board);
        playAgain();
    }

    private void playAgain() {
        print.playAgain();
        print.options(playCommands());
        playAgainCommand(getSelection(playCommands()));
    }

    private List<Options> playCommands() {
        return Arrays.asList(new PlayAgain(), new Quit(this));
    }

     private void playAgainCommand(int selection) {
        Options playOrQuit = playCommands().get(selection - 1);
        playOrQuit.execute();
    }

    public void quitApp() {
        appRunning = false;
        print.exiting();
    }
}