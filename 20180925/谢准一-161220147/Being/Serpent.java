package Being;
public class Serpent extends  Creature{


    public Serpent() {
        super("蛇精", '&');
        x = 0;
        y = 0;

    }
    public Serpent(int i, int j) {
        super("蛇精", '&');
        x = i;
        y = j;

    }
    public void setPosition(int i, int j) {
        x = i;
        y = j;
    }
    public char return_symbol() {
        return symbol;
    }
    public int getX() { return x; }
    public int getY() { return y;};

}
