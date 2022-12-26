import java.util.Scanner;

public class MainMenu {

    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("------ Revolutionary TicTacToe! ------");

        while (true) {
            System.out.println();
            System.out.println("MODE MENU:");
            System.out.println("1. TicTacToe");
            //System.out.println("2. Minesweeper");
            //System.out.println("3. TicTacSweeper");
            System.out.println("4. Exit");
            System.out.println();

            int opt = Utils.readInt("Select your option: ");

            if (opt == 4) {
                System.out.println("Bye!");
                System.exit(0);
            }

            switch (opt) {
                case 1:
                    TicTacToe.tictactoe();
                    break;

                case 2:
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Not a valid game mode!");
            }

        }
    }

}