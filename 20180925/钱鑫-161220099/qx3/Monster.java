package qx3;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private Snake snake;
    private Scorpion scorpion;
    private List<Underling> underlings;
    public Monster()
    {
        snake=new Snake();
        scorpion=new Scorpion();
        underlings=new ArrayList<Underling>();
    }
    public void init(int n)
    {
        for(int i=0;i<n;i++)
        {
            Underling underling=new Underling();
            underlings.add(underling);
        }
    }
    public Snake getSnake()
    {
        return snake;
    }
    public Scorpion getScorpion()
    {
        return scorpion;
    }
    public List<Underling> getUnderlings()
    {
        return underlings;
    }
}
