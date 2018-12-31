package Being;
public class Followers extends Creature{


    public Followers(){
        super("Follower", '*');
        x = 0;
        y = 0;

    }
    public Followers(int i, int j) {
        super("Follower", '*');
        x = i;
        y = j;

    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
