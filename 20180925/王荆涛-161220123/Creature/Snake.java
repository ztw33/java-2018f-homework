package Creature;


import CommonMethods.PointNode;
import Formation.Formation;

public class Snake extends Monster{
    private Formation newFormation;

    public Snake(){
        setxPoint(14);
        setyPoint(7);
        setName("S");
        newFormation = new Formation();
    }

    public void addToBattle(){
        System.out.println("小的们，集合给我上啊！");
    }

    public void changeFormation(String name, PointNode[] pos){
        newFormation.Formation(name, "邪恶", pos, this.getxPoint(), this.getyPoint());
    }

}
