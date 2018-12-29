package Creature;

import CommonMethods.Dispatcher;
import CommonMethods.PointNode;
import Formation.Formation;
/**
 * 生物抽象类及其子类的实现
 */
public abstract class Creature {
    private int xPoint;
    private int yPoint;
    private String name;

    Creature(){ }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxPoint() {
        return xPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }
}

abstract class Monster extends Creature{
    private static int flunkyCount = 6;
    private static int snakeCount = 1;
    private static int scorpionCount = 1;
    private PointNode[] monsterPos = new PointNode[flunkyCount + snakeCount + scorpionCount];

    Monster(){}

    public PointNode[] getMonsterPos() {
        return monsterPos;
    }

    public void setMonsterPos(PointNode[] monsterPos) {
        this.monsterPos = monsterPos;
    }
}

abstract class GoodGuy extends Creature{
    private static int calaCount = 7;
    private static int grandpaCount = 1;
    private PointNode[] goodGuyPos = new PointNode[calaCount + grandpaCount];

    GoodGuy(){}

    public PointNode[] getGoodGuyPos() {
        return goodGuyPos;
    }

    public void setGoodGuyPos(PointNode[] goodGuyPos) {
        this.goodGuyPos = goodGuyPos;
    }

}







