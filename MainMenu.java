import java.util.Scanner;

public class MainMenu {

    public static Scanner lector = new Scanner(System.in);
    public static boolean showRules = false;

    public static void main(String[] args) throws Exception{
        //Introduction to the program
        System.out.println("------ Revolutionary TicTacToe! ------");
        System.out.println("Loading data...");

        //Player selection
        Player.printAvailablePlayers();
        Player p1 = Player.selectPlayer("Select Player 1: ");
        Player p2 = Player.selectPlayer("Select Player 2: ");

        //Program Started, will continue printing menu and reading options until exit instruction
        while (true) {
            System.out.println();
            System.out.println("MODE MENU:");
            System.out.println("1. TicTacToe");
            // System.out.println("2. Minesweeper");
            System.out.println("3. MineTacToe");
            System.out.println("4. Show rules");
            System.out.println("0. Exit");
            System.out.println();

            int opt = Utils.readInt("Select your option: ");

            //Exit option
            if (opt == 0) {
                System.out.println("Bye!");
                System.exit(0);
            }

            //Starting the games
            switch (opt) {
                case 1:
                    TicTacToe.tictactoe(p1, p2, false);
                    break;

                case 2:
                    break;

                case 3:
                    TicTacToe.tictactoe(p1, p2, true);

                case 4:
                    System.out.println(GameMechanics.rules);
                    break;

                default:
                    System.out.println("Not a valid game mode!");
            }

        }
    }

}