package com.pelensky.tictactoe.App;

public class UI {

    private final IO io;

    public UI(IO io){
        this.io = io;
    }

    private boolean validateInput(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected int getInteger() {
        int integer = -1;
        while (integer < 0){
            String selection = io.getInput();
            if (validateInput(selection) ){
                integer = Integer.parseInt(selection);
            } else {
                io.print("Please select an integer");
            }
        } return integer;
    }
}
