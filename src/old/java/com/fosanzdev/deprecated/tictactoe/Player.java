package com.fosanzdev.deprecated.tictactoe;

public class Player {
    private final String name;
    private final char mark;
    private final int victories;

    /**
     * Creates a new Player
     * 
     * @param name      name of the player
     * @param mark      char to be used in the game
     * @param victories Number of victories, should be only handled by the program
     *                  itself
     */
    public Player(String name, char mark, int victories) {
        this.name = name;
        this.mark = mark;
        this.victories = victories;
    }

    public String getName() {
        return name;
    }

    public char getMark() {
        return mark;
    }

    public int getVictories() {
        return victories;
    }
}
