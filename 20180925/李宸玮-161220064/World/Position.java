package World;

import Creature.Creature;

import java.util.List;

public class Position{
    public int x;
    public int y;
    public void setPositoin(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void changePosition(int xpos,int ypos){
        this.x+=xpos;
        this.y+=ypos;
    }
    //根据pos即队列中第一个人的位置来确定整个队列的位置
}
