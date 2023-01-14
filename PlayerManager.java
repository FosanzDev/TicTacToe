import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {

    private static final ArrayList<Player> players = new ArrayList<Player>();
    private static final Scanner lector = MainMenu.lector;

    /**
     * Prints the players list and waits the user to select one
     * 
     * @returns selected player
     */
    public static Player selectPlayer(String msg) {
        System.out.print(msg);
        return players.get(lector.nextInt());
    }

    /**
     * Reads the config file at ./data/config.txt and adds the player to the players
     * list
     * The file has to be in the following format:
     * name mark victories
     * The first line is ignored
     * 
     */
    public static void importPlayers() {
        try {
            Scanner config = new Scanner(FileSystems.getDefault().getPath("data", "config.txt"));
            config.nextLine();
            while (config.hasNextLine()) {
                players.add(new Player(config.next(), config.next().charAt(0), config.nextInt()));
            }
            config.close();
        } catch (IOException e) {
            System.out.println("Error reading config file");
        }
    }

    /**
     * Prints the players list
     */
    public static void printPlayers() {
        System.out.println("--------------------");
        System.out.println("Players: ");
        for (int i = 0; i < players.size(); i++)
            System.out.println(i + ". " + players.get(i).getName() + "|| Mark: " + players.get(i).getMark());
        System.out.println("--------------------");
        System.out.println();
    }

    /**
     * Adds a new player to the players list from the user input
     *
     */

    public static void addPlayer() {
        System.out.print("Name: ");
        String name = lector.next();
        lector.nextLine();
        System.out.print("Mark: ");
        char mark = lector.nextLine().charAt(0);
        players.add(new Player(name, mark, 0));
    }

    /**
     * Edits a player with user input
     */
    public static void modifyPlayer() {
        printPlayers();
        Player p = selectPlayer("Select the player to modify: ");
        System.out.println("Current name: " + p.getName());
        System.out.print("New name: ");
        String name = lector.next();
        lector.nextLine();
        System.out.println("Current mark: " + p.getMark());
        System.out.print("New mark:");
        char mark = lector.nextLine().charAt(0);
        players.set(players.indexOf(p), new Player(name, mark, p.getVictories()));
    }

    /**
     * Deletes a player from the players list
     */
    public static void deletePlayer() {
        printPlayers();
        players.remove(selectPlayer("Select the player to delete: "));

    }

    /**
     * Deletes the config file and writes a new one with the current players list
     */
    public static void exportPlayers() {
        try {
            java.nio.file.Files.delete(FileSystems.getDefault().getPath("data", "config.txt"));
            java.io.PrintWriter config = new java.io.PrintWriter(
                    FileSystems.getDefault().getPath("data", "config.txt").toFile());
            config.print("name mark victories");
            for (Player p : players) {
                config.println();
                config.print(p.getName() + " " + p.getMark() + " " + p.getVictories());
            }
            config.close();
        } catch (IOException e) {
            System.out.println("Error writing config file");
        }
    }
}
