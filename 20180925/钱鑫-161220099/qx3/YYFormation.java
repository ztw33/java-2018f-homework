package qx3;

import java.util.List;

public class YYFormation implements MonsterFormation {
    @Override
    public void formation(Monster monster,Battlefield battlefield)
    {
        int n=battlefield.getN();
        Snake snake=monster.getSnake();
        Scorpion scorpion=monster.getScorpion();
        monster.init(18);
        List<Underling> underlings=monster.getUnderlings();
        battlefield.setPosition(n-1,n-1,snake);
        battlefield.setPosition((n-1)/2,n-4,scorpion);
        for(int i=1;i<=2;i++)
        {
            for(int j=-1;j<2;j++)
            {
                battlefield.setPosition((n-1)/2+j,n-7+i,underlings.get(j+i*i));
            }
        }
        battlefield.setPosition((n-1)/2-1,n-4,underlings.get(6));
        battlefield.setPosition((n-1)/2+1,n-4,underlings.get(7));
        battlefield.setPosition((n-1)/2-2,n-4,underlings.get(8));
        battlefield.setPosition((n-1)/2+2,n-4,underlings.get(9));
        battlefield.setPosition((n-1)/2-2,n-3,underlings.get(10));
        battlefield.setPosition((n-1)/2+2,n-3,underlings.get(11));
        battlefield.setPosition((n-1)/2-3,n-3,underlings.get(12));
        battlefield.setPosition((n-1)/2+3,n-3,underlings.get(13));
        battlefield.setPosition((n-1)/2-3,n-2,underlings.get(14));
        battlefield.setPosition((n-1)/2+3,n-2,underlings.get(15));
        battlefield.setPosition((n-1)/2-4,n-1,underlings.get(16));
        battlefield.setPosition((n-1)/2+4,n-1,underlings.get(17));
    }
}
