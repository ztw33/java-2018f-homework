package Being;
public class grandpa extends Creature{

    public grandpa() {
        super("爷爷", '@');
        x = 0;
        y = 0;

    }
    public grandpa(int i, int j) {
        super("爷爷", '@');
        x = i;
        y = j;
    }
    public void setPosition(int i, int j){
        x = i;
        y = j;
    }
    public char return_symbol(){
        return symbol;
    }
    public int getY() {
        return y;
    }
    public int getX(){
        return x;
    }
    public char getSymbol() { return symbol; }
}
