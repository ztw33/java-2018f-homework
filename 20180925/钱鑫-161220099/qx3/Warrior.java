package qx3;

import java.util.ArrayList;
import java.util.List;

public class Warrior {
    private Grandpa grandpa;
    private List<Calabash> calabashes;
    public Warrior()
    {
        grandpa=new Grandpa();
        calabashes=new ArrayList<Calabash>();
    }
    public void init()
    {
        Calabash calabash1=new Calabash(4);
        Calabash calabash2=new Calabash(7);
        Calabash calabash3=new Calabash(1);
        Calabash calabash4=new Calabash(3);
        Calabash calabash5=new Calabash(2);
        Calabash calabash6=new Calabash(5);
        Calabash calabash7=new Calabash(6);
        calabashes.add(calabash1);
        calabashes.add(calabash2);
        calabashes.add(calabash3);
        calabashes.add(calabash4);
        calabashes.add(calabash5);
        calabashes.add(calabash6);
        calabashes.add(calabash7);
    }
    public Grandpa getGrandpa()
    {
        return grandpa;
    }
    public List<Calabash> getCalabashes()
    {
        return calabashes;
    }
    public void Bubblesort()
    {
        for(int i=0;i<6;i++) {
            for (int j = 0; j <6-i; j++) {
                if (calabashes.get(j).getRank() > calabashes.get(j+1).getRank()) {
                    Calabash calabash=calabashes.get(j);
                    calabashes.set(j,calabashes.get(j+1));
                    calabashes.set(j+1,calabash);
                }
            }
        }
    }
}
