package com.fosanzdev.deprecated.tictactoe;

public class GameProperties {

    public static int DIMENSION = 3;
    public static int WINNING_LENGTH = 3;
    public static char[][] tablero = new char[DIMENSION][DIMENSION];

    public static void gameProperties() {
        while (true) {

            System.out.println();
            System.out.println("GAME PROPERTIES:");
            System.out.println("1. Change dimension");
            System.out.println("0. Exit");
            System.out.println();

            int opt = Utils.readInt("Select your option: ");

            switch (opt) {
                case 1:
                    int newDim = Utils.readInt("Enter new dimension: ");
                    changeDimension(newDim);
                    changeWinningLength(newDim);
                    break;

                case 0:
                    System.out.println("Exiting game properties...");
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    /**
     * Changes the dimension of the game and resets the board
     * @param dimension
     */
    public static void changeDimension(int dimension) {
        DIMENSION = dimension;
        tablero = new char[DIMENSION][DIMENSION];
    }

    /**
     * Changes the winning length of the game
     * @param winningLength
     */
    public static void changeWinningLength(int winningLength) {
        WINNING_LENGTH = winningLength;
    }
}
