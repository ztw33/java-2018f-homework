package field;

public class Position {
    private int x;
    private int y;
    public Position(int x,int y){
        this.x=x;
        this.y=y;
    }


    public void up(){
        x=x-1;
    }
    public void down(){
        x=x+1;
    }
    public void left(){
        y=y-1;
    }
    public void right(){
        y=y+1;
    }


    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
