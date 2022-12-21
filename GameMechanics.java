import java.util.Arrays;

public class GameMechanics {

    private static char[][] tablero = TicTacToe.tablero;
    private final static int DIMENSION = TicTacToe.DIMENSION;

    /**
     * Clears the board
     */
    public static void newGame() {
        for (char[] a : tablero) {
            Arrays.fill(a, ' ');
        }
    }

    /**
     * Places a toe of user 0/1 (o/x) into row, column positions
     * 
     * @param r   Row
     * @param c   Column
     * @param usr User (0 for o, 1 for x)
     */
    public static void placeToe(int r, int c, boolean usr) throws Exception {
        if (tablero[r][c] != ' ')
            throw new Exception();

        tablero[r][c] = usr ? 'x' : 'o';
        TicTacToe.toeCount++;
    }

    /**
     * Prints actual Board
     */
    public static void printBoard() {
        System.out.println(Utils.multiplyString(" _", DIMENSION));
        for (char[] r : tablero) {
            System.out.print("|");
            for (char c : r) {
                System.out.printf("\033[4m%c\033[0m|", c);
            }
            System.out.println();
        }

    }

    /**
     * Checks if <code>ficha</code> wins
     * 
     * @param ficha char with the selected value
     * @return true/false depending if <code>ficha</code> has won
     */
    public static boolean checkWin(char ficha, int times) {
        int count = 0;

        // Check Lines

        for (int r = 0; r < DIMENSION; r++) {
            for (int c = 0; c < DIMENSION; c++) {
                char usr = tablero[r][c];

                if (usr == ficha)
                    count++;
            }
            if(count==DIMENSION)
                return true;

            count = 0;
        }

        // Check Columns

        for (int c = 0; c < DIMENSION; c++) {
            for (int r = 0; r < DIMENSION; r++) {
                char usr = tablero[r][c];

                if (usr == ficha)
                    count++;
            }

            if (count == DIMENSION)
                return true;
            
            count = 0;
        }


        //Checking diagonals

        int countDiag1 = 0;
        int countDiag2 = 0;

        //Checking Top-Left to Bottom-Right
        for(int i=0; i<DIMENSION; i++){
            if (tablero[i][i] == ficha)
                countDiag1++;

            if (tablero[i][DIMENSION - i - 1] == ficha)
                countDiag2++;
        }

        return countDiag1 == DIMENSION || countDiag2 == DIMENSION;

    }

    /**
     * Checks if <code>turn</code> has won the game
     * 
     * @param turn <code>true/false -- 'x'/'o'</code> respectively
     * @return if <code>turn</code> won or not;
     */
    public static boolean checkWin(boolean turn, int times) {
        return checkWin(turn ? 'x' : 'o', times);
    }
}
