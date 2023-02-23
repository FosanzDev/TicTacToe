package com.fosanzdev.deprecated.tictactoe;

public class TicTacToe {

    public static void tictactoe(Player p1, Player p2, boolean mines) {

        boolean continues;

        // Do this while the players want to continue playing
        do {
            continues = true;
            
            //Starts the game and returns the winner
            Player result = TacToeGames.tactoegame(p1, p2, mines);
            
            //Winning message
            if(result != null){
                System.out.println("Player " + result.getName() + " won!");
            }

            //Draw message
            else{
                System.out.println("It's a draw!");
            }

            // Ask players if they want to continue
            continues = Utils.readOption("Continue playing?(y/n): ");

        } while (continues);

    }
}
