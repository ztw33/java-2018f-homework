public class Grandpa extends Creature{
    private String name;
    Grandpa(){
        name="爷爷";
        x=y=0;
        number=8;party=0;
    }
    Grandpa(int get_x,int get_y){
        name="爷爷";
        x=get_x;y=get_y;
        number=8;party=0;
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
    public void Cheer(){
        System.out.println("Cheer! (from 爷爷)");
    }
}
