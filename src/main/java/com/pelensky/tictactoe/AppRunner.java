package com.pelensky.tictactoe;

import java.util.List;

class AppRunner {

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
    print.options(gameFactory.gameTypes());
    return gameFactory.createGame(getSelection(gameFactory.gameTypes()), board);
  }

  private Board createBoard() {
    print.selectBoard();
    print.options(boardFactory.boardTypes());
    return boardFactory.createBoard(getSelection(boardFactory.boardTypes()));
  }

  private int getSelection(List<String> options) {
    return input.validateSelection(input.validSelections(options));
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
    PlayAgain playAgain = new PlayAgain();
    print.playAgain();
    print.options(playAgain.quitOptions());
    playAgain.playAgain(getSelection(playAgain.quitOptions()), this);
  }

  void quitApp() {
    appRunning = false;
    print.exiting();
  }
}
