package Formation;

import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：鹤翼阵
 */
public class HeyiBattleArray<T extends Creature> {
    public void form(T scorpionMonster,T[] underlings,int row,int column)
    {
        scorpionMonster.standOnMap(row,column);
        //System.out.println(underlings.length/2);
        for(int k=0;k<(underlings.length/2);k++)
        {
            underlings[k*2].standOnMap(row-k-1,column+k+1);
            underlings[k*2+1].standOnMap(row+k+1,column+k+1);
            //System.out.println(k);
        }
    }
}
