package Huluwa;

public interface MBuilder {
    //用来建立空间与活物之间的联系
    public void swapTwoPosition(Position pos1,Position pos2);
    public void buildSpaceInOrder(Space space,Creature []creatures);
    public void buildSpaceInForamtion(MFormation formation,Space space,Creature []creatures);
    public void randomBuild(Space space,Creature []creatures);
    public void clearPos(Space space);
}
