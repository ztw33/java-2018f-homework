package qx3;

import java.util.List;

public class HYFormation implements MonsterFormation {
    @Override
    public void formation(Monster monster,Battlefield battlefield)
    {
        int n=battlefield.getN();
        Snake snake=monster.getSnake();
        Scorpion scorpion=monster.getScorpion();
        monster.init(10);
        List<Underling> underlings=monster.getUnderlings();
        battlefield.setPosition(n-1,n-1,snake);
        battlefield.setPosition((n-1)/2,n-1,scorpion);
        for(int i=1;i<=5;i++)
        {
            battlefield.setPosition((n-1)/2-i,n-1-i,underlings.get(i-1));
            battlefield.setPosition((n-1)/2+i,n-1-i,underlings.get(i-1));
        }
    }
}
