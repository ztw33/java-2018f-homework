package Huluwa;

import java.util.Random;

public class MPoint1D implements MPoint {
    int x;
    //一维的点，只有一个坐标轴

    public MPoint1D(int x){
        this.x = x;
    }

    @Override
    public MPoint getPoint(){
        return this;
    }

    @Override
    public void copyPoint(MPoint point){
        this.x = ((MPoint1D)point).getX();
    }

    @Override
    public String toString(){return String.valueOf(x);}

    public int getX(){
        return this.x;
    }

    public void setX(int x){
        this.x = x;
    }

    public static MPoint1D getRandom(int rangeX){
        MPoint1D point = new MPoint1D(0);
        Random randomNumber = new Random();
        point.setX(randomNumber.nextInt(rangeX) % (rangeX));
        return point;

    }


}
