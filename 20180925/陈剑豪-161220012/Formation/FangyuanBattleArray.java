package Formation;
import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：方円
 */
public class FangyuanBattleArray<T extends Creature> {
    public void form(T scorpionMonster,T[] underlings,int row,int column)
    {
        scorpionMonster.standOnMap(row,column);
        //System.out.println(underlings.length/2);
        for(int k=0;k<=(underlings.length/4);k++)
        {
            underlings[2*k].standOnMap(row-k-1,column+k+1);
            underlings[2*k+1].standOnMap(row+k+1,column+k+1);
        }
        for(int k=(underlings.length/4)+1;k<(underlings.length/2);k++)
        {
            underlings[2*k].standOnMap(row-underlings.length/4-1+(k-underlings.length/4),column+k+1);
            underlings[2*k+1].standOnMap(row+underlings.length/4+1-(k-underlings.length/4),column+k+1);
        }
    }
}
