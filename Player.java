import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.FileSystems;


public class Player {
    private final String name;
    private final char mark;
    private final int victories;
    private static final ArrayList<Player> players = new ArrayList<Player>();

    /**
     * Creates a new Player
     * @param name name of the player
     * @param mark char to be used in the game
     * @param victories Number of victories, should be only handled by the program itself
     */
    public Player(String name, char mark, int victories) {
        this.name = name;
        this.mark = mark;
        this.victories = victories;
    }

    public String getName() {
        return name;
    }

    public char getMark() {
        return mark;
    }

    public int getVictories() {
        return victories;
    }

    /**
     * Reads the config file and print the names of the detected Players
     * @throws IOException
     */
    public static void printAvailablePlayers() throws IOException {
        Scanner config = new Scanner(FileSystems.getDefault().getPath("data", "config.txt"));

        System.out.println("Jugadores encontrados: ");
        while (config.hasNextLine()) {
            config.nextLine();
            players.add(new Player(config.next(), config.next().charAt(0), config.nextInt()));
        }

        for (int i = 0; i < players.size(); i ++) {
            System.out.println("Jugador " + i + ": " + players.get(i).getName());
        }

    }

    /**
     * Waits for the user to select a player from the list
     * @param msg Personalized request message
     * @return the player as a Player
     */
    public static Player selectPlayer(String msg) {
        System.out.println();
        int n = Utils.readInt(msg);
    
        return players.get(n);

    }
}
