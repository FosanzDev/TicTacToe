public class TicTacToe {
    // Initialize variables
    private final static int DIMENSION = GameMechanics.DIMENSION;
    public static int toeCount = 0;

    public static void tictactoe(Player p1, Player p2, boolean mines) {

        boolean continues;
        GameMechanics.newGame();

        // Do this while the players want to continue playing
        do {
            continues = true;
            boolean win = false;
            boolean mine = false;
            Player turn = p2;

            if(mines){
                GameMechanics.placeMines();
            }

            // While no-one has won...
            while (!win) {
                // Print the board and change the
                GameMechanics.printBoard();
                turn = turn == p1 ? p2 : p1;

                // User request + toe placing
                mine = GameMechanics.placeToe("\nInput desired position: (row/column): ", turn.getMark(), mines);
                
                if (mine){
                    win = true;
                    turn = turn == p1 ? p2:p1;
                    break;
                }

                // Draft counter increases per toe placed
                toeCount++;
                // Checks if the toe placed made a winning pattern
                win = GameMechanics.checkWin(turn.getMark());

                // Checks if it is a draft
                if (toeCount == DIMENSION * DIMENSION)
                    break;
            }

            // Print the final board
            GameMechanics.printBoard();

            // Prints wether the game was ended by draft or win
            if (win)
                System.out.println("Ha ganado " + turn.getName());

            else
                System.out.println("Es un empate!");

            // Reset board
            toeCount = 0;
            GameMechanics.newGame();

            // Ask players if they want to continue
            continues = Utils.readOption("Continue playing?(y/n): ");

        } while (continues);

    }
}
