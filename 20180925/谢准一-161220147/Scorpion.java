public class Scorpion extends Creature{
    private int x;
    private int y;

    Scorpion(){
        super("蝎子精", '$');
        x = 0;
        y = 0;

    }
    Scorpion(int i, int j) {
        super("蝎子精", '$');
        x = i;
        y = j;
    }
    void SetPositon(int i, int j) {
        x = i;
        y = j;
    }
    int GetX(){
        return x;
    }
    int GetY() {
        return y;
    }
    public void StandToField() {
        Calabash.battlefield[x][y] = symbol;
    }
}
