package qx2;

import java.util.*;

public class Battlefield {
    private int N;
    private List<List<Boolean>> isbeing;
    private List<List<Creature>> creature;
    public Battlefield(int N)
    {
        this.N=N;
        isbeing=new ArrayList<List<Boolean>>();
        creature=new ArrayList<List<Creature>>();
        for(int i=0;i<N;i++)
        {
            List<Boolean> isbeinglist=new ArrayList<Boolean>();
            List<Creature> creaturelist=new ArrayList<Creature>();
            for(int j=0;j<N;j++)
            {
                isbeinglist.add(false);
                creaturelist.add(null);
            }
            isbeing.add(isbeinglist);
            creature.add(creaturelist);
        }
    }
    public int getN()
    {
        return N;
    }
    public void setPosition(int x,int y,Creature creature)
    {
        if(x<0||y<0||x>N-1||y>N-1)
        {
            System.out.print("超出了战场范围！\n");
        }
        else if(isbeing.get(x).get(y))
        {
            System.out.print("战场上该位置有人了！！！");
        }
        else
        {
            this.isbeing.get(x).set(y,true);
            this.creature.get(x).set(y,creature);
        }
    }
    public void printBattlefield()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(isbeing.get(i).get(j))
                {
                    System.out.print(creature.get(i).get(j).getName());
                }
                else
                {
                    System.out.print("    ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
