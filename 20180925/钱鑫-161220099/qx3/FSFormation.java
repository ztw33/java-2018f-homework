package qx3;

import java.util.List;

public class FSFormation implements MonsterFormation {
    @Override
    public void formation(Monster monster,Battlefield battlefield)
    {
        int n=battlefield.getN();
        Snake snake=monster.getSnake();
        Scorpion scorpion=monster.getScorpion();
        monster.init(11);
        List<Underling> underlings=monster.getUnderlings();
        battlefield.setPosition(n-1,n-1,snake);
        battlefield.setPosition((n-1)/2,n-1,scorpion);
        for(int i=1;i<=5;i++)
        {
            battlefield.setPosition((n-1)/2,n-1-i,underlings.get(i-1));
        }
        battlefield.setPosition((n-1)/2-1,n-5,underlings.get(5));
        battlefield.setPosition((n-1)/2+1,n-5,underlings.get(6));
        battlefield.setPosition((n-1)/2-2,n-4,underlings.get(7));
        battlefield.setPosition((n-1)/2+2,n-4,underlings.get(8));
        battlefield.setPosition((n-1)/2-3,n-3,underlings.get(9));
        battlefield.setPosition((n-1)/2+3,n-3,underlings.get(10));
    }
}
