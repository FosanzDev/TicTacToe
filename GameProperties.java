public class GameProperties {

    public static int DIMENSION = 3;
    public static char[][] tablero = new char[DIMENSION][DIMENSION];

    public static void gameProperties() {
        while (true) {

            System.out.println();
            System.out.println("GAME PROPERTIES:");
            System.out.println("1. Change dimension");
            System.out.println("0. Exit");
            System.out.println();

            int opt = Utils.readInt("Select your option: ");

            switch (opt) {
                case 1:
                    DIMENSION = Utils.readInt("Enter new dimension: ");
                    tablero = new char[DIMENSION][DIMENSION];
                    break;

                case 0:
                    System.out.println("Exiting game properties...");
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
