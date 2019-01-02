package Creature;
import BattleField.*;
/**
 * @ Author     ：cjh
 * @ Description：小喽啰
 */
public class Underlings extends Creature{/**创建人：陈剑豪 创建时间：2018.10.2*/
    static int number=0;
    public Underlings()
    {
        init();
        name="喽啰";
        number++;
        list.add(this);
    }
    public static void Number()
    {
        System.out.println(number);
    }// 统计小喽啰的数量
    @Override
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=Existance.underlings;

    }

}
