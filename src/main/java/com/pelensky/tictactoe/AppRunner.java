package com.pelensky.tictactoe;

import com.pelensky.tictactoe.GameTypes.*;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private IO io;

    public AppRunner(IO io){
        this.io = io;
    }

    public void run(){
        io.print(welcome());
        io.print(instructions());
        startNewGame(select());
    }

     private List<GameType> gameTypes() {
        return Arrays.asList(
                new HumanVSHuman(),
                new HumanVSComputer(),
                new ComputerVSComputer(),
                new Quit());
    }

    private String instructions(){
        StringBuilder instructions = new StringBuilder();
        for (int i=0; i < gameTypes().size(); i++){
            instructions.append(i + 1).append(") ").append(gameTypes().get(i).instruction()).append(System.lineSeparator());
        }
        return instructions.toString().trim();
    }

    private int select(){
        return Integer.parseInt(io.getInput());
    }

    private void startNewGame(int choice){
        GameType newGame = gameTypes().get(choice - 1);
        newGame.execute();
    }

    private String welcome() {
        return "Tic Tac Toe" + System.lineSeparator() + "Select Game Type";
    }


}
