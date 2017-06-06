package com.pelensky.tictactoe;

import com.pelensky.tictactoe.Boards.BigBoard;
import com.pelensky.tictactoe.Boards.Boards;
import com.pelensky.tictactoe.Boards.NormalBoard;
import com.pelensky.tictactoe.Commands.GameType;
import com.pelensky.tictactoe.PlayAgainOptions.Options;
import com.pelensky.tictactoe.PlayAgainOptions.PlayAgain;
import com.pelensky.tictactoe.PlayAgainOptions.Quit;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private final List<GameType> gameTypes;
    private Game game;
    private Input input;
    private Print print;
    private boolean appRunning = true;

    AppRunner(Input input, Print print, List<GameType> gameTypes) {
        this.input = input;
        this.print = print;
        this.gameTypes = gameTypes;
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
        createGame(board);
    }

    private void createGame(Board board) {
        print.gameType();
        print.options(gameTypes);
        game = startNewGame(getSelection(gameTypes), board);
    }

    private Board createBoard() {
        print.boardSize();
        print.options(boardTypes());
        return selectBoardSize(getSelection(boardTypes()));
    }

    private int getSelection(List<? extends Menu> options) {
        return input.validateSelection(input.validSelections(options));
    }

    private Game startNewGame(int choice, Board board) {
        GameType newGame = gameTypes.get(choice - 1);
        return newGame.execute(board);
    }

    private Board selectBoardSize(int choice) {
        Boards board = boardTypes().get(choice - 1);
        return board.execute();
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

    private List<Boards> boardTypes() {
        return Arrays.asList(new NormalBoard(), new BigBoard());
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