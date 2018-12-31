package Being;


public class Creature {
    protected String name;
    protected char symbol;
    protected int x;
    protected int y;

    Creature() {}

    public Creature(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;

    }

    public int getX() { return x; }

    public int getY() { return y; }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
