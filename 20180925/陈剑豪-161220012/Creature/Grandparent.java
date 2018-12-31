package Creature;
import BattleField.*;
/**
 * @ Author     ：cjh
 * @ Description：爷爷
 */
public class Grandparent extends Creature{/**创建人：陈剑豪 创建时间：2018.10.2*/
    public Grandparent()
    {
        init();
        name="爷爷";
        list.add(this);
    }
    @Override
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=Existance.grandparent;

    }
    public void cheer()
    {

    }
}
