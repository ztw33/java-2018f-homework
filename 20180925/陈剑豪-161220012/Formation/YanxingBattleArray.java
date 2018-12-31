package Formation;

import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：雁行阵
 */
public class YanxingBattleArray {
    public static void form(Creature scorpionMonster,Creature[] underlings,int row,int column)
    {
        scorpionMonster.standOnMap(row,column);
        for(int k=0;k<underlings.length;k++)
        {
            underlings[k].standOnMap(row-k-1,column+k+1);
            //System.out.println(k);
        }
    }
}
