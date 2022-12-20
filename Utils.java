public class Utils {

    /**
     * Removes whitespaces and scape characters of a string
     * 
     * @param text String to be cleaned
     * @return The clean String
     */
    public static String cleanString(String text) {
        return text.trim().replaceAll("\\s+", " ");
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

}