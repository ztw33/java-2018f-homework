public class Brother extends Creature{
    private String name;//葫芦娃名字
    private Color color;//葫芦娃颜色

    Brother(int get_number,String get_name,Color get_color){
        number=get_number;
        party=0;
        name=get_name;
        color=get_color;
        x=y=0;
    }
    Brother(int get_number,String get_name,Color get_color,int get_x,int get_y){
        number=get_number;
        party=0;
        name=get_name;
        color=get_color;
        x=get_x;y=get_y;
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
    public void report_color(){//打印颜色
        System.out.println(color);
    }
}