package Creature;
import BattleField.*;
/**
 * @ Author     ：cjh
 * @ Description：蛇精
 */
public class SnakeMonster extends Creature{/**创建人：陈剑豪 创建时间：2018.10.2*/
    public SnakeMonster()
    {
        init();
        name="蛇精";
        list.add(this);
    }
    @Override
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=Existance.snake;

        //System.out.println("蛇精"+" "+row+" "+column);
    }
    public void cheer()
    {

    }
}
