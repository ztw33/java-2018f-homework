package Formation;
import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：一字长蛇阵
 */
public class FengshiBattleArray<T extends Creature> {
    public void form(T scorpionMonster,T[] underlings,int row,int column)
    {
        scorpionMonster.standOnMap(row,column);
        //System.out.println(underlings.length/2);
        for(int k=0;k<(underlings.length/3);k++)
        {
            underlings[k*2].standOnMap(row-k-1,column+k+1);
            underlings[k*2+1].standOnMap(row+k+1,column+k+1);
            //System.out.println(k);
        }
        for(int k=(underlings.length/3);k<(underlings.length/2);k++)
        {
            underlings[k*2].standOnMap(row,column+2*(k-underlings.length/3)+1);
            underlings[k*2+1].standOnMap(row,column+2*(k-underlings.length/3)+2);
        }
        if(underlings.length>(underlings.length/2)*2)
        {
            underlings[underlings.length-1].standOnMap(row,column+2*(underlings.length/2-underlings.length/3)+1);
        }
    }
}
