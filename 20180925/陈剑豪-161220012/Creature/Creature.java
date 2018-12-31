package Creature;
import java.util.*;
/**
 * @ Author     ：cjh
 * @ Description：生物基类
 */
public class Creature {

    protected int row;//生物在地图上的横坐标
    protected int column;//生物在地图上的纵坐标
    protected String name;//生物的名字
    public void reportName(){System.out.print(name+"  ");}//生物报自己的名字
    public void standOnMap(int i,int j){}//生物站上地图
    public void init(){row=-1;column=-1;}//生物坐标初始化
    public static LinkedList<Creature> list = new LinkedList<Creature>();
}
