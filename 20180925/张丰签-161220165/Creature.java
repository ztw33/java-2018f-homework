public class Creature {//生物类，包含所有生物共有的属性和行为
    int x;//二维坐标
    int y;
   // private int hp;
   // private int attack;
    int number;//生物编号,用于区分生物
    int party;//生物所处阵营,0代表葫芦娃，1代表蛇精

    Creature(){
        x=0;y=0;
        number=0;party=0;
    }
    Creature(int pos_x,int pos_y,int num,int pt){
        x=pos_x;y=pos_y;
        number=num;party=pt;
    }
    public int report_number(){//报告自己的编号
        return number;
    }
    public int report_party(){//报告自己的阵营
        return party;
    }
    public void show_pos(){//打印位置
        System.out.println("("+x+","+y+")");
    }
    public void move(int to_x,int to_y){//生物移动
        System.out.println("("+x+","+y+") -> ("+to_x+","+to_y+")");
        x=to_x;y=to_y;
    }
}

