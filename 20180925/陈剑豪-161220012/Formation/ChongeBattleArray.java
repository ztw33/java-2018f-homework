package Formation;
import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：衝轭阵
 */
public class ChongeBattleArray<T extends Creature> {
    public void form(T scorpionMonster,T[] underlings,int row,int column)
    {
        scorpionMonster.standOnMap(row,column);
        //System.out.println(underlings.length/2);
        for(int k=0;k<(underlings.length/2);k++)
        {
            underlings[k*2].standOnMap(row+1,column+2*k+1);
            underlings[k*2+1].standOnMap(row,column+2*k+2);
            //System.out.println(k);
        }
    }
}
