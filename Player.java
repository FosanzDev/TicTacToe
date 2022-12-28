public class Player {
    private final String name;
    private final char mark;
    private final int victories;


    public Player(String name, char mark, int victories){
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
}
