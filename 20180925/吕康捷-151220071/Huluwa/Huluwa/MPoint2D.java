package Huluwa;

import java.util.Random;

public class MPoint2D implements MPoint{
    //2D点，两个坐标轴

    private int x;
    private int y;

    MPoint2D(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public MPoint2D getPoint(){
        return this;
    }

    public void setPoint(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public  void copyPoint(MPoint point){
        MPoint2D newPoint = (MPoint2D)point;
        this.x = newPoint.getX();
        this.y = newPoint.getY();
    }

    @Override
    public String toString(){return "("+String.valueOf(x)+","+String.valueOf(y)+")";}

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}

    //产生一个随机的点
    public static MPoint2D getRandom(int rangeX,int rangeY){
        MPoint2D point = new MPoint2D(0,0);
        Random randomNumber = new Random();
        point.setX(randomNumber.nextInt(rangeX) % (rangeX));
        point.setY(randomNumber.nextInt(rangeX) % (rangeX));
        return point;
    }
}
