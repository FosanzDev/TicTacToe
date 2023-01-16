public class TicTacToe {

    public static void tictactoe(Player p1, Player p2, boolean mines) {

        boolean continues;
        GameMechanics.initialize();

        // Do this while the players want to continue playing
        do {
            continues = true;
            boolean win = false;
            boolean mine = false;
            Player turn = p2;

            if (mines) {
                GameMechanics.placeMines();
                // GameMechanics.placeWarnings();

            }

            // While no-one has won...
            while (!win) {
                // Print the board and change the
                GameMechanics.printBoard(false);
                turn = turn == p1 ? p2 : p1;

                // User request + toe placing
                mine = GameMechanics.placeToe("\nInput desired position: (row/column): ", turn.getMark(), mines);

                if (mine) {
                    win = true;
                    turn = turn == p1 ? p2 : p1;
                    break;
                }

                // Checks if the toe placed made a winning pattern
                win = GameMechanics.checkWin(turn.getMark());

                // Checks if it is a draft
                if (GameMechanics.checkDraft())
                    break;
            }

            // Print the final board
            GameMechanics.printBoard(true);

            // Prints wether the game was ended by draft or win
            if (win)
                System.out.println("Ha ganado " + turn.getName());

            else
                System.out.println("Es un empate!");

            GameMechanics.initialize();

            // Ask players if they want to continue
            continues = Utils.readOption("Continue playing?(y/n): ");

        } while (continues);

    }
}
