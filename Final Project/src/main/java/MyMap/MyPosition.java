package MyMap;

public class MyPosition{
    public int x,y;
    public MyPosition(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return x + "," + y;
    }
}