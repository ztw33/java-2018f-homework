package Formation;
import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：偃月阵
 */
public class YanyueBattleArray<T extends Creature> {
    public void form(T scorpionMonster,T[] underlings,int row,int column)
    {
        scorpionMonster.standOnMap(row,column);
        int test=0;
        for(;test*test<underlings.length;test++)
        {
            ;
        }
        int num=0;
        for(int i=1;i<=test;i++)
        {
            if(num<underlings.length) {
                {
                    underlings[num].standOnMap(row,column+i);
                    num++;
                }
            for(int k=0;k<i;k++)
            {
                    if (num < underlings.length) {
                        underlings[num].standOnMap(row - k - 1, column + k + i);
                        num++;
                        if (num < underlings.length) {
                            underlings[num].standOnMap(row + k + 1, column + k + i);
                            num++;
                        }
                    }
                }
                //System.out.println(k);
            }
        }
    }
}
