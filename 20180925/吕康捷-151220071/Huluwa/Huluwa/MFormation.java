package Huluwa;

public abstract class MFormation {

    //阵型类，包含起点，点集以及相关操作

    protected MPoint startPoint;
    protected MPoint []pointset;
    protected int numOfPoint;

    public void setStartPoint(MPoint point){
        startPoint = point;
    }//设置阵型起点
    public MPoint getStartPoint(){
        return startPoint;
    }

    public MPoint[] getAllPoint(){
        return pointset;
    } //返回所有的点

    public abstract void generateDefaultFormation();

}
