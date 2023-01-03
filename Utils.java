import java.util.Scanner;
import java.util.InputMismatchException;

public class Utils {

    private static Scanner lector = MainMenu.lector;

    /**
     * Removes whitespaces and scape characters of a string
     * 
     * @param text String to be cleaned
     * @return The clean String
     */
    public static String cleanString(String text) {
        return text.trim().replaceAll("\\s+", "");
    }

    /**
     * Multiplies a String by n times
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String s = multiplyString("hola", 3)
     * //    s = "holaholahola"
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s     String to be multiplied
     * @param times N times that s will be multiplied
     * @return String with the multiplied String
     */
    public static String multiplyString(String s, int times) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++)
            sb.append(s);

        return sb.toString();
    }

    /**
     * Reads an integer with a personalized message
     * 
     * @param msj String with the message
     * @return Validated integer
     */
    public static int readInt(String msj) {
        int res = 0;
        boolean valid;

        do {
            System.out.print(msj);
            valid = true;
            try {
                res = lector.nextInt();
                lector.nextLine();
            } catch (InputMismatchException e) {
                lector.nextLine();
                System.out.println("Invalid Entry");
                valid = false;
            }
        } while (!valid);

        return res;
    }

    /**
     * Reads and returns a true/false user statement
     * @param msj Personalized request message
     * @return boolean with the user selection
     */
    public static boolean readOption(String msj) {
        System.out.print(msj);
        return lector.nextLine().charAt(0) == 'y';
    }

}