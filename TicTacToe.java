import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static char[][] tablero;
    public final static int DIMENSION = 3;
    public static int toeCount = 0;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        tablero = new char[DIMENSION][DIMENSION];

        boolean continues;
        GameMechanics.newGame();

        do {
            continues = true;
            boolean win = false;
            boolean turn = true;

            while (!win) {
                GameMechanics.printBoard();
                System.out.print("\nIntroduzca posicion deseada: [fila, columna]: ");
                boolean error;

                do {
                    error = false;
                    try {
                        String[] res = lector.nextLine().split(",");
                        int[] pos = new int[2];
                        for (int i = 0; i < 2; i++)
                            pos[i] = Integer.parseInt(Utils.cleanString(res[i]));

                        GameMechanics.placeToe(pos[0] - 1, pos[1] - 1, turn);

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


                if(toeCount == DIMENSION*DIMENSION)
                    break;

                win = GameMechanics.checkWin(turn, DIMENSION);
                turn = turn ? false : true;
            }

            GameMechanics.printBoard();

            if(win)
                System.out.println("Han ganado las " + (!turn ? 'x' : 'o'));

            else
                System.out.println("Es un empate!");
            
            toeCount = 0;

            GameMechanics.newGame();

            System.out.print("Quiere continuar? (s/n): ");
            continues = lector.nextLine().charAt(0) == 's' ? true : false;

        } while (continues);

        lector.close();
    }
}
