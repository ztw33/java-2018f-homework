package renyi2;

public class NullCreature extends Creature{
    NullCreature(int x,int y)
    {
        super(null);
        this.Imageurl=null;
        this.x=x;
        this.y=y;
        this.name="    ";
    }
}
