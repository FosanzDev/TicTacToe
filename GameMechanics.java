import java.util.Arrays;

public class GameMechanics {

    private static char[][] tablero = TicTacToe.tablero;
    private final static int FILAS = TicTacToe.FILAS;
    private final static int COLUMNAS = TicTacToe.COLUMNAS;

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
    }

    /**
     * Prints actual Board
     */
    public static void printBoard() {
        System.out.println(Utils.multiplyString(" _", COLUMNAS));
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
    public static boolean checkWin(char ficha) {
        int count = 0;

        // Check Lines

        for (int r = 0; r < FILAS; r++) {
            for (int c = 0; c < COLUMNAS; c++) {
                char usr = tablero[r][c];

                if (usr == ficha) {
                    if (count == 2)
                        return true;
                    else
                        count++;
                }

                else
                    count = 0;
            }
            count = 0;
        }

        // Check Columns

        for (int c = 0; c < COLUMNAS; c++) {
            for (int r = 0; r < FILAS; r++) {
                char usr = tablero[r][c];

                if (usr == ficha) {
                    if (count == 2)
                        return true;
                    else
                        count++;
                }

                else
                    count = 0;
            }
        }

        return false;
    }

    /**
     * Checks if <code>turn</code> has won the game
     * 
     * @param turn <code>true/false -- 'x'/'o'</code> respectively
     * @return if <code>turn</code> won or not;
     */
    public static boolean checkWin(boolean turn) {
        return checkWin(turn ? 'x' : 'o');
    }
}
