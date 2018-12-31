package bjy.SevenChairs;

import java.lang.String;
//颜色作为葫芦娃的一个属性分属于一个enum类处理
enum COLOR{
    RED("红色"),ORANGE("橙色"),YELLOW("黄色"),GREEN("绿色"),QING("青色"),BLUE("蓝色"),PURPLE("紫色");
    private String name;
    private COLOR(String a){
        this.name = a;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String a){
        this.name = a;
    }
};
public class Brother {
    private int rank;
    private COLOR color;
    //private int chair_number;
    private String name;
    public Brother (int ranking){
        rank=ranking;
        //chair_number=chair;
        switch (ranking)
        {
            case 0:name=new String ("老大");color=COLOR.RED;break;
            case 1:name=new String ("老二");color=COLOR.ORANGE;break;
            case 2:name=new String ("老三");color=COLOR.YELLOW;break;
            case 3:name=new String ("老四");color=COLOR.GREEN;break;
            case 4:name=new String ("老五");color=COLOR.QING;break;
            case 5:name=new String ("老六");color=COLOR.BLUE;break;
            case 6:name=new String ("老七");color=COLOR.PURPLE;break;
        }
    }

    public int GetRank(){
        return rank;
    }
    /*public int GetPlace(){
        return this.chair_number;
    }*/
    public String GetName(){
        return name;
    }
    public COLOR GetColor(){
        return color;
    }
    //交换两个位置
    public void DeclareExchange(int before, int after){
        System.out.println(name+":"+before+"->"+after);
    }
    //比自己排位前返回false；否则返回true
    //与前面相邻的兄弟比较
    public boolean compare_brother(Brother bro){
        if(bro.GetRank() > rank){
            return true;
        }
        else
            return false;
    }
    //设置颜色
    /*public void SetColor(String col) {
        color = col;
    }*/
    //设置名字
    public void SetName(String nm) {
        name = nm;
    }
    //设置大小
    public void SetRank(int rk) {
        rank = rk;
    }
    //交换位置
    public void SetPlace(int position) {
        //System.out.println(name+":"+this.chair_number+"->"+position);
        //chair_number=position;
    }
    //打印状态
    public void Display(){
        System.out.println("这是"+name+"  颜色是"+color.getName());
    }
    public void DisplayAge(){
        System.out.println("这是"+name);
    }
    public void DisplayColor(){
        System.out.println("颜色是"+color.getName());
    }
}
