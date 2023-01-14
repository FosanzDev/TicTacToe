import java.util.Scanner;

public class Config {

    private final static Scanner lector = MainMenu.lector;

    public static void configMenu() {

        while (true) {
            System.out.println();
            System.out.println("CONFIG MENU:");
            System.out.println("1. Add player");
            System.out.println("2. Remove player");
            System.out.println("3. Edit player");
            System.out.println("4. Show players");
            System.out.println("5. Reselect players");
            System.out.println("0. Exit");

            int opt = Utils.readInt("Select your option: ");

            //Exit option
            if (opt == 0) {
                System.out.println("Exiting config menu...");
                return;
            }

            switch (opt) {
                case 1:
                    PlayerManager.addPlayer();
                    break;
                case 2:
                    PlayerManager.deletePlayer();
                    break;
                case 3:
                    PlayerManager.modifyPlayer();
                    break;
                case 4:
                    PlayerManager.printPlayers();
                    //Press enter to continue
                    System.out.println("Press enter to continue...");
                    lector.nextLine();
                    break;

                case 5:
                    System.out.println("Actual players:");
                    System.out.println("Player 1: " + MainMenu.player1.getName());
                    System.out.println("Player 2: " + MainMenu.player2.getName());
                    System.out.println("-------------------");
                    PlayerManager.printPlayers();
                    MainMenu.player1 = PlayerManager.selectPlayer("Select new player 1: ");
                    MainMenu.player2 = PlayerManager.selectPlayer("Select new player 2: ");
                    break;
                    
                    
                default:
                    System.out.println("Not a valid option!");
            }
            
            System.out.println("Saving data...");
            PlayerManager.exportPlayers();

        }

    }
}
