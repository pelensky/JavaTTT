package com.pelensky.tictactoe.Players;

import com.pelensky.tictactoe.Game;

import java.util.HashMap;
import java.util.Map;

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
    Map<Integer, Integer> bestScore = new HashMap<>();
    return calculateBestMove(game, 0, bestScore);
  }

  private int calculateBestMove(Game game, int depth, Map<Integer, Integer> bestScore) {
    int tiedGame = 0;
    int wonGame = -1;
    if (game.isGameTied()) {
      return tiedGame;
    } else if (game.isGameOver()){
      return wonGame;
    } else {
      checkPossibilities(game, depth, bestScore);
      if (depth == 0) {
        return getBestMove(bestScore);
      } else {
        return getTopScore(bestScore);
      }
    }
  }

  private void checkPossibilities(Game game, int depth, Map<Integer, Integer> bestScore) {
    for (int space : game.board.getAvailableSpaces()) {
      game.board.placeMarker(space, game.getCurrentPlayer().getMarker());
      game.changeCurrentPlayer();
      bestScore.put(space, (-1 * calculateBestMove(game, depth + 1, new HashMap<>())));
      game.board.resetSpace(space);
      game.changeCurrentPlayer();
    }
  }

  private int getBestMove(Map<Integer, Integer> bestScore) {
    return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
  }

  private int getTopScore(Map<Integer, Integer> bestScore) {
    return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
  }

  @Override
  public String title() {
    return null;
  }
}
