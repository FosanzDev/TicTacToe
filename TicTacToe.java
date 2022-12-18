import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import t6lib.Utils;

public class TicTacToe {
    private static char[][] tablero;
    private final static int FILAS = 3;
    private final static int COLUMNAS = 3;

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
    public static void placeToe(int r, int c, boolean usr) throws Exception{
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

    public static boolean checkWin(boolean turn) {
        int count = 0;

        //Check Lines

        for(int r=0; r<FILAS; r++){
            for(int c=0; c<COLUMNAS; c++){
                char usr = tablero[r][c];

                if (usr == (turn ? 'x': 'o')){
                    if(count==2)
                        return true;
                    else 
                        count++;
                }    
                    
                else count = 0;
            }
            count=0;
        }

        //Check Columns

        for(int c=0; c<COLUMNAS; c++){
            for(int r=0; r<FILAS; r++){
                char usr = tablero[r][c];

                if (usr == (turn ? 'x': 'o')){
                    if(count==2)
                        return true;
                    else 
                        count++;
                }    
                    
                else count = 0;
            }
        }

        //Check Diagonals LTR

        for(int i=0; i<COLUMNAS-3)
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        tablero = new char[FILAS][COLUMNAS];

        boolean continues;
        newGame();

        do {
            continues = true;
            boolean win = false;
            boolean turn = true;

            while (!win) {
                printBoard();
                System.out.print("\nIntroduzca posicion deseada: [fila, columna]: ");
                boolean error;

                do {
                    error = false;
                    try {
                        String[] res = lector.nextLine().split(",");
                        int[] pos = new int[2];
                        for (int i = 0; i < 2; i++)
                            pos[i] = Integer.parseInt(Utils.cleanString(res[i]));

                        placeToe(pos[0] - 1, pos[1] - 1, turn);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no valida");
                        System.out.print("--> ");
                        error = true;
                    } catch (Exception x) {
                        System.out.println("Posicion no valida");
                        System.out.print("--> ");
                        error = true;
                    }

                } while (error);

                win = checkWin(turn) || checkWin(!turn);
                turn = turn ? false : true;
            }

            System.out.println("Han ganado las " + (turn ? 'x':'o'));

            newGame();

            System.out.print("Quiere continuar? (s/n): ");
            continues = lector.nextLine().charAt(0) == 's' ? true : false;

        } while (continues);

        lector.close();
    }
}
