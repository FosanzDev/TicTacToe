import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private final static int DIMENSION = GameMechanics.DIMENSION;
    public static int toeCount = 0;
    private static Scanner lector = MainMenu.lector;

    public static void tictactoe(Player p1, Player p2) {

        boolean continues;
        GameMechanics.newGame();

        do {
            continues = true;
            boolean win = false;
            Player turn = p2;

            while (!win) {
                GameMechanics.printBoard();
                System.out.print("\nIntroduzca posicion deseada: [fila, columna]: ");
                boolean error;
                turn = turn == p1 ? p2 : p1;

                do {
                    error = false;
                    try {
                        String[] res = lector.nextLine().split(",");
                        int[] pos = new int[2];
                        for (int i = 0; i < 2; i++)
                            pos[i] = Integer.parseInt(Utils.cleanString(res[i]));

                        GameMechanics.placeToe(pos[0] - 1, pos[1] - 1, turn.getMark());

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no valida");
                        System.out.print("Nueva posicion --> ");
                        error = true;
                    } catch (Exception x) {
                        System.out.println("Posicion no valida");
                        System.out.print("Nueva posicion--> ");
                        error = true;
                    }

                } while (error);

                win = GameMechanics.checkWin(turn.getMark(), DIMENSION);
                if (toeCount == DIMENSION * DIMENSION)
                    break;
            }

            GameMechanics.printBoard();

            if (win)
                System.out.println("Han ganado las " + turn.getMark());

            else
                System.out.println("Es un empate!");

            toeCount = 0;

            GameMechanics.newGame();

            continues = Utils.readOption("Continue playing?(y/n): ");

        } while (continues);

    }
}
