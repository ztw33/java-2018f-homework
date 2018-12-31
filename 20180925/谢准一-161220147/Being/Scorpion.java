package Being;
public class Scorpion extends Creature{

    public Scorpion(){
        super("蝎子精", '$');
        x = 0;
        y = 0;

    }
    public Scorpion(int i, int j) {
        super("蝎子精", '$');
        x = i;
        y = j;
    }
    void SetPositon(int i, int j) {
        x = i;
        y = j;
    }


}
