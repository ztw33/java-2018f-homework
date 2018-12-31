public class Snake extends Creature{
    private String name;
    Snake(){
        name="蛇精";
        x=y=0;
        number=10;party=1;
    }
    Snake(int get_x,int get_y){
        name="蛇精";
        x=get_x;y=get_y;
        number=10;party=1;
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
    public void Cheer(){
        System.out.println("Cheer! (from 蛇精)");
    }
}
