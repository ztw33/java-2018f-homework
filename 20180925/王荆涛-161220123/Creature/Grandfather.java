package Creature;

import CommonMethods.Dispatcher;
import CommonMethods.PointNode;
import Formation.Formation;
import Ground.GroundCreater;
import Ground.Point;
import MainDemo.*;

public class Grandfather extends GoodGuy{
    private Formation newFormation;

    public Grandfather(){
        setxPoint(0);
        setyPoint(7);
        setName("G");
        newFormation = new Formation();
    }

    public void addToBattle(){
        System.out.println("葫芦娃们，加油啊！");
    }

    public void changeFormation(String name, PointNode[] pos){
        newFormation.Formation(name, "正义", pos, this.getxPoint(), this.getyPoint());
    }
}
