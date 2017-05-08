package com.pelensky.tictactoe.App;

public class Input {

    private final IO io;

    public Input(IO io) {
        this.io = io;
    }


    protected int getInteger() {
        int integer = -1;
        while (integer < 0) {
            String selection = io.getInput();
            if (validateInput(selection)) {
                integer = Integer.parseInt(selection);
            } else {
                io.print("Please select an integer");
            }
        }
        return integer;
    }

    private boolean validateInput(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
