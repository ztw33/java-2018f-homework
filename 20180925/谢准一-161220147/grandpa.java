public class grandpa extends Creature{
    private int x;
    private int y;
    grandpa() {
        super("爷爷", '@');
        x = 0;
        y = 0;

    }
    grandpa(int i, int j) {
        super("爷爷", '@');
        x = i;
        y = j;
    }
    public void set_position(int i, int j){
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
}
