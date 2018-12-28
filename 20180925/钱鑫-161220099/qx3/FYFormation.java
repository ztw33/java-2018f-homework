package qx3;

import java.util.List;

public class FYFormation implements MonsterFormation {
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
        battlefield.setPosition((n-1)/2,n-7,underlings.get(0));
        battlefield.setPosition((n-1)/2-1,n-6,underlings.get(1));
        battlefield.setPosition((n-1)/2+1,n-6,underlings.get(2));
        battlefield.setPosition((n-1)/2-2,n-5,underlings.get(3));
        battlefield.setPosition((n-1)/2+2,n-5,underlings.get(4));
        battlefield.setPosition((n-1)/2-3,n-4,underlings.get(5));
        battlefield.setPosition((n-1)/2+3,n-4,underlings.get(6));
        battlefield.setPosition((n-1)/2-2,n-3,underlings.get(7));
        battlefield.setPosition((n-1)/2+2,n-3,underlings.get(8));
        battlefield.setPosition((n-1)/2-1,n-2,underlings.get(9));
        battlefield.setPosition((n-1)/2+1,n-2,underlings.get(10));
    }
}
