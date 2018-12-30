package Formation;

import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：一字长蛇阵
 */
public class ChangsheBattleArray<T extends Creature> {
    public void form(T[] brothers, int row, int column)
    {
        for(int i=row;i<row+7;i++)
        {
            brothers[i-row].standOnMap(i,column);
        }
    }
}
