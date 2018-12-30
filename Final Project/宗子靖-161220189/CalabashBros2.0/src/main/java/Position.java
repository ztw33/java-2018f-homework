public class Position{//代表位置的对象
    private int x;
    private int y;
    Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    Position(Position pos){
        setPos(pos);
    }
    public void setPos(Position pos){
        x=pos.x;
        y=pos.y;
    }
    public void changePos(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public void addX(int a){
        x+=a;
    }
    public void addY(int b){
        y+=b;
    }
    public final Position addPosWithChange(Position pos){//改变本位置，返回本位置
        x+=pos.x;
        y+=pos.y;
        return this;
    }
    public Position addPosWithoutChange(Position pos){//返回一个新的改变后的位置，本位置不改变
        Position res=new Position(x,y);
        return res.addPosWithChange(pos);
    }
    public boolean overZeroPoint(){//判断位置是否在第一象限
        if(x>0&&y>0)
            return true;
        else
            return false;
    }
    public static boolean oneStepClose(Position aPos,Position bPos){
        if(Math.abs(aPos.getX()-bPos.getX())==1&&aPos.getY()-bPos.getY()==0)
            return true;
        if(Math.abs(aPos.getY()-bPos.getY())==1&&aPos.getX()-bPos.getX()==0)
            return true;
        return false;
    }
    public static int distance(Position aPos,Position bPos){
        return Math.abs(aPos.getX()-bPos.getX())+Math.abs(aPos.getY()-bPos.getY());
    }
}
