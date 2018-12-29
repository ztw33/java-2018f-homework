package CalabashBrosVSMobs;

public class Being {//生物
    static final int type=-1;
    protected Position pos;
    protected String name;
    public Being(){
        name="noname";
        pos=new Position(0,0);
    }
    public Being(String name){
        this.name=name;
    }
    public final String getName() {
        return name;
    }
    public final Position getPos(){
        return pos;
    }
    public void changePos(int x, int y){
        pos.changePos(x,y);
    }
}

class GoodBeing extends Being{
    static final int type=0;
    GoodBeing(){
        name="noname";
        pos=new Position(0,0);
    }
    GoodBeing(String name){
        this.name=name;
    }
}
class EvilBeing extends Being{
    static final int type=1;
    EvilBeing(String name){
        this.name=name;
    }
}