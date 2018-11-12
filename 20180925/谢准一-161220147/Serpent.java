public class Serpent extends  Creature{
    private int x;
    private int y;
    private char symbol;
    Serpent() {
        super("蛇精", '&');
        x = 0;
        y = 0;

    }
    Serpent(int i, int j) {
        super("蛇精", '&');
        x = i;
        y = j;

    }
    public void set_position(int i, int j) {
        x = i;
        y = j;
    }
    public char return_symbol() {
        return symbol;
    }
}
