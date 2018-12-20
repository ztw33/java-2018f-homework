package group;
import creature.*;
import space.TwoDimensionSpace;
import formation.*;
public class Monsters implements Group {
    private Creature[] member;
    private Creature observer;
    public Monsters(int n) {
        member = new Creature[n+1];
        member[0] = new Scorpion();
        for (int i = 1; i <= n; i++){
            member[i] = new Demon();
        }
        observer = new Snake();
    }
    public Monsters(){

    }
    public void generateFormation(Formation formation, TwoDimensionSpace space, int x, int y, int direction)
    {
        formation.generateFormation(space, member, observer, x, y, direction);
    }
}
