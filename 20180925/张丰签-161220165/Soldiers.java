public class Soldiers extends Creature{
    private boolean is_leader;//0不是队长，1是队长
    private String name;
    Soldiers(){
        x=y=0;
        number=0;
        party=1;
        is_leader=false;
        name="蝎子";
    }
    Soldiers(int get_x,int get_y,int num,boolean leader){
        x=get_x;y=get_y;
        number=num;
        party=1;
        is_leader=leader;
        if(is_leader)
            name="蝎精";
        else
            name="蝎子";
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }

}