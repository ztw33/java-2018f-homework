package qx3;

import java.util.List;

public class WarriorFormation {
    public void formation(Warrior warrior,Battlefield battlefield)
    {
        int n=battlefield.getN();
        warrior.init();
        warrior.Bubblesort();
        Grandpa grandpa=warrior.getGrandpa();
        List<Calabash> calabashes=warrior.getCalabashes();
        battlefield.setPosition(0,0,grandpa);
        for(int i=-3;i<=3;i++)
        {
            battlefield.setPosition((n-1)/2+i,0,calabashes.get(i+3));
        }
    }
}
