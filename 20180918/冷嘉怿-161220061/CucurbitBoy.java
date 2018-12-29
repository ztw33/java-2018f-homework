//package ljy.Cucurbit;
//葫芦七兄弟
enum CucurbitBoys{
    RedBro, OrangeBro, YellowBro, GreenBro, BlueBro, IndigoBro, VioletBro;
    static protected String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    static protected String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    public String getName(){ return names[ordinal()]; }
    public String getColor(){ return colors[ordinal()]; }
}

public class CucurbitBoy {
    //按照排行顺序存放葫芦娃的姓名和颜色
    static protected int nextid=0;     //每个葫芦娃都是唯一的，nextid用来记录下一个未出生的葫芦娃排行
    private CucurbitBoys id;            //每个葫芦娃拥有自己的id，描述他在兄弟中的排行
    CucurbitBoy() throws Exception {
        //每个葫芦娃只能出生一次，并且最多有七个
        if(CucurbitBoy.nextid>=7)
        {
            throw new Exception("葫芦娃只有七个！");
        }
        //为葫芦娃分配排行
        this.id=CucurbitBoys.values()[CucurbitBoy.nextid];
        CucurbitBoy.nextid++;
    }
    //返回自己的颜色
    public String tellColor(){ return id.getColor(); }
    //返回自己的姓名
    public String tellName() { return id.getName(); }
    //返回自己的排行
    public int getID(){ return id.ordinal(); }
}