import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class GameMechanics {

    public final static Random gen = new Random();
    public final static Scanner lector = MainMenu.lector;
    public final static int DIMENSION = 3;
    public final static char[][] tablero = new char[DIMENSION][DIMENSION];

    /**
     * Prints the rules of all games
     */
    public static String rules = """
            Tic-Tac-Toe:
                Your objective is to perform 3 consecutive same marks
                vertically, horizontally or diagonally. Each player will
                place a mark per turn only on non already chosen places.

            Mine-Tac-Toe:
                Same rules as Tic-Tac-Toe, but this time bomb are added
                to the board!. If you mark at one bomb, you lose!
            """;

    /**
     * Clears the board
     */
    public static void newGame() {
        for (char[] a : tablero) {
            Arrays.fill(a, ' ');
        }
    }

    /**
     * Places a mark on the desired position of the board
     * 
     * @param r    row of the board
     * @param c    column of the board
     * @param mark mark going to be placed
     */
    public static void placeToe(int r, int c, char mark) {
        tablero[r][c] = mark;
    }

    /**
     * Request the user a 2 dimension entry with a personalized message
     * Numbers have to be separated by a comma
     * 
     * @param msg  Personalized message to be printed
     * @param mark Mark that is going to be placed
     */
    public static boolean placeToe(String msg, char mark, boolean mines) {
        boolean error = false;

        System.out.print(msg);

        // Infinite request until correct position
        do {
            // If this line is executed, an error has been occurred
            if (error)
                System.out.print("New position --> ");
            error = false;

            // Catch possible errors
            try {
                String[] res = Utils.cleanString(lector.nextLine()).split(",");
                int row = Integer.parseInt(res[0]) - 1;
                int col = Integer.parseInt(res[1]) - 1;

                if (mines && tablero[row][col] == '\\'){
                    System.out.println("It's a mine, you lost!");
                    return true;
                }

                // Error if the position is taken
                if (tablero[row][col] != ' ') {
                    error = true;
                    System.out.println("Already marked position");
                    // Jumps the toe placing
                    continue;
                }

                // Place the toe if it's a correct position
                placeToe(row, col, mark);

                // Catch the possible input mismatch
            } catch (InputMismatchException i) {
                System.out.println("Invalid input");
                error = true;

                // Catch the possible out of bounds
            } catch (ArrayIndexOutOfBoundsException a) {
                System.out.println("Invalid position");
                error = true;
            }

        } while (error);

        return false;
    }

    /**
     * Prints actual Board
     */
    public static void printBoard() {
        System.out.println(Utils.multiplyString(" _", DIMENSION));
        for (char[] r : tablero) {
            System.out.print("|");
            for (char c : r) {
                // \ character responds to mines. Don't print them
                if (c == '\\')
                    c = ' ';
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

        for (int r = 0; r < DIMENSION; r++) {
            for (int c = 0; c < DIMENSION; c++) {
                char usr = tablero[r][c];

                if (usr == ficha)
                    count++;
            }
            if (count == DIMENSION)
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

        // Checking diagonals

        int countDiag1 = 0;
        int countDiag2 = 0;

        for (int i = 0; i < DIMENSION; i++) {
            // Checking Top-Left to Bottom-Right
            if (tablero[i][i] == ficha)
                countDiag1++;

            // Checking Top-Right to Bottom-Left
            if (tablero[i][DIMENSION - i - 1] == ficha)
                countDiag2++;
        }

        return countDiag1 == DIMENSION || countDiag2 == DIMENSION;

    }

    /**
     * Places \ character on random positions of tablero. DIMENSION-2 mines are placed
     */
    public static void placeMines() {
        int count = 0;
        while (count < DIMENSION - 2) {
            int r = gen.nextInt(DIMENSION);
            int c = gen.nextInt(DIMENSION);

            if (tablero[r][c] == ' ') {
                tablero[r][c] = '\\';
                count++;
            }
        }
    }

}