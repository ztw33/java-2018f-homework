public class Creature {//生物类，包含所有生物共有的属性和行为
    protected int x;//生物的二维坐标
    protected int y;
    protected int number;//生物编号,用于区分生物
    protected CreatureType type;
    protected String name;
    Creature(int start_x,int start_y,int num,CreatureType type,String name){
        this.x=start_x;
        this.y=start_y;
        this.number=num;
        this.type=type;
        this.name=name;
    }
    Creature(int num,CreatureType type,String name){
        this.x=0;
        this.y=0;
        this.number=num;
        this.type=type;
        this.name=name;
    }
    Creature(){
        this.x=this.y=0;
        this.number=0;
    }
    public int get_x(){
        return this.x;
    }
    public int get_y(){
        return this.y;
    }
    public String get_name(){
        return this.name;
    }
    public int get_number(){
        return this.number;
    }
    public CreatureType get_type(){
        return this.type;
    }
    public void show_pos(){
        System.out.println("("+x+","+y+")");
    }
    public void move(int to_x,int to_y){//生物移动
        //System.out.println("("+x+","+y+") -> ("+to_x+","+to_y+")");
        x=to_x;y=to_y;
    }

}
