package qx3;

import java.util.List;

public class YLFormation implements MonsterFormation {
    @Override
    public void formation(Monster monster,Battlefield battlefield)
    {
        int n=battlefield.getN();
        Snake snake=monster.getSnake();
        Scorpion scorpion=monster.getScorpion();
        monster.init(9);
        List<Underling> underlings=monster.getUnderlings();
        battlefield.setPosition(n-1,n-1,snake);
        battlefield.setPosition((n-1)/2,n-1,scorpion);
        for(int i=1;i<=3;i++)
        {
            for(int j=0;j<(2*i-1);j++)
            {
                battlefield.setPosition((n-1)/2-i+1+j,n-5+i,underlings.get(j+(i-1)*(i-1)));
            }
        }
    }
}
