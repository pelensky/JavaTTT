package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Game;

import java.util.HashMap;

public class UnbeatableComputerPlayer implements Player {

  private final String marker;

  public UnbeatableComputerPlayer(String marker) {
    this.marker = marker;
  }

  @Override
  public String getMarker() {
    return marker;
  }

  @Override
  public int getMove(Game game) {
    //      return game.board.getAvailableSpaces().get(0);
    int depth = 0;
    HashMap bestScore = new HashMap();
    return calculateBestMove(game, depth, bestScore);
  }

  private int calculateBestMove(Game game, int depth, HashMap bestScore) {
    if (game.isGameOver()) {
      return scoreScenarios(game);
    }
    return 0;
  }

  private int scoreScenarios(Game game) {
    Player opponent = getOpponent(game);
    if (game.isGameWonBy(opponent)) {
      return -1;
    } else if (game.isGameWonBy(this)) {
      return 1;
    } else {
      return 0;
    }
  }

  private Player getOpponent(Game game) {
    Player opponent;
    if (marker.equals(game.getCurrentPlayer().getMarker())) {
      opponent = game.getCurrentOpponenet();
    } else {
      opponent = game.getCurrentPlayer();
    }
    return opponent;
  }

  @Override
  public String title() {
    return null;
  }
}
