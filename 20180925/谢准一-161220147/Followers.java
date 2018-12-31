public class Followers extends Creature{

    private int x;
    private int y;
    Followers(){
        super("Follower", '*');
        x = 0;
        y = 0;

    }
    Followers(int i, int j) {
        super("Follower", '*');
        x = i;
        y = j;

    }
    public void StandToField() {
        Calabash.battlefield[x][y] = symbol;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
