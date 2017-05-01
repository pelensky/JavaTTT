package com.pelensky.tictactoe;

class Game {

    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;

    Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    void takeTurn(int space) {
        board.takeTurn(space, currentPlayer.getMarker());
        changeCurrentPlayer();
    }

    private void changeCurrentPlayer() {
        currentPlayer = (currentPlayer.equals(player1)) ? (currentPlayer = player2) : (currentPlayer = player1);
    }


}
