package com.fosanzdev.deprecated.tictactoe;

import java.util.Random;

public class AntiTacToe extends GameProperties {

    private static Random gen = GameMechanics.gen;

    public static void antitactoe(Player p1, Player p2) {

        boolean continues;

        do {
            changeDimension(5);
            changeWinningLength(3);
            GameMechanics.initialize();

            Player[] players = { p1, p2 };

            do {
                // Fill the first and the last row with random toes from the players
                for (int i = 0; i < DIMENSION; i++) {
                    tablero[0][i] = players[gen.nextInt(2)].getMark();
                    tablero[DIMENSION - 1][i] = players[gen.nextInt(2)].getMark();
                }

                // Fill the first and the last column with random toes from the players
                for (int i = 0; i < DIMENSION; i++) {
                    tablero[i][0] = players[gen.nextInt(2)].getMark();
                    tablero[i][DIMENSION - 1] = players[gen.nextInt(2)].getMark();
                }

            } while (GameMechanics.checkWin(p1.getMark(), 3)
                    || GameMechanics.checkWin(p2.getMark(), 3));

            Player res = TacToeGames.tactoegame(p1, p2, false);

            if (res != null) {
                System.out.println("The winner is " + (res == p1 ? p2 : p1).getName() + "!");
            }

            else {
                System.out.println("It's a draw!");
            }

            continues = Utils.readOption("Continue playing?(y/n): ");

        } while (continues);

    }
}