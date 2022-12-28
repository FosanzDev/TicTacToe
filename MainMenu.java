import java.util.Scanner;

public class MainMenu {

    public static Scanner lector = new Scanner(System.in);
    public static boolean showRules = false;

    public static void main(String[] args) {
        System.out.println("------ Revolutionary TicTacToe! ------");
        System.out.println("Loading data...");

        Player p1 = new Player("Esteban", 'x', 0);
        Player p2 = new Player("Otro", 'o', 0);

        while (true) {
            System.out.println();
            System.out.println("MODE MENU:");
            System.out.println("1. TicTacToe");
            // System.out.println("2. Minesweeper");
            // System.out.println("3. TicTacSweeper");
            System.out.println("4. Show rules");
            System.out.println("0. Exit");
            System.out.println();

            int opt = Utils.readInt("Select your option: ");

            if (opt == 0) {
                System.out.println("Bye!");
                System.exit(0);
            }

            switch (opt) {
                case 1:
                    TicTacToe.tictactoe(p1, p2);
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    System.out.println(GameMechanics.rules);
                    break;

                default:
                    System.out.println("Not a valid game mode!");
            }

        }
    }

}