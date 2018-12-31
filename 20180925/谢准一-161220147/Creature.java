public class Creature {
    protected String name;

    protected char symbol;

    Creature() {}
    Creature(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;

    }


    public char getSymbol() {
        return symbol;
    }


    public String getName() {
        return name;
    }
}
