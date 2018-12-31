package Creature;

public class Calabash extends Creature{

    enum COLOR{
        RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE
    }
    private int position;
    private int rank;
    private COLOR color;
    public Calabash(int n){
        switch (n){
            case 1: this.color=COLOR.RED; this.name="老大";break;
            case 2: this.color=COLOR.ORANGE; this.name="老二";break;
            case 3: this.color=COLOR.YELLOW; this.name="老三";break;
            case 4: this.color=COLOR.GREEN; this.name="老四";break;
            case 5: this.color=COLOR.CYAN; this.name="老五";break;
            case 6: this.color=COLOR.BLUE; this.name="老六";break;
            case 7: this.color=COLOR.PURPLE; this.name="老七";break;
        }
        this.rank=n;
        this.position=0;
    }

    public int getRank(){
        return this.rank;
    }

    public COLOR getColor(){ return this.color; }

    public int getPosition() { return position; }

    public  int setPosition(int n) {
        this.position = n;
        return n;
    }
}