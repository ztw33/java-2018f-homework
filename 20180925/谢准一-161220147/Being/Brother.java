package Being;

public class Brother extends Creature {
    private int rank;
    private String color;


    public Brother(String name, String color, char symbol, int rank){
        super(name, symbol);
        this.color = color;
        this.rank = rank;

    }
    public Brother(String name, String color, char symbol, int rank, int x, int y) {
        super(name, symbol);
        this.color = color;
        this.rank = rank;
        this.x = x;
        this.y = y;
    }
    public int get_rank() {return rank;}

    public void set_position(int i, int j) {
        x = i;
        y = j;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public char get_symbol() {
        return symbol;
    }
}
