package Creature;
/**
 * @ Author     ：cjh
 * @ Description：葫芦娃枚举
 */
public enum CalabashEnum {/**创建人：陈剑豪 创建时间：2018.9.18*/
    BigBrother("老大","红色",1),SecondBrother("老二","橙色",2),ThirdBrother("老三","黄色",3),FourthBrother("老四","绿色",4),
    FifthBrother("老五","青色",5), SixthBrother("老六","蓝色",6),SeventhBrother("老七","紫色",7);
    String name;// 葫芦娃的名字
    String color;// 葫芦娃的颜色
    int rank;// 葫芦娃中的排行
    CalabashEnum(String name,String color,int rank)
    {
        this.name =name;
        this.color=color;
        this.rank=rank;
    }
    public int getRank()
    {
        return this.rank;
    }
    public String getName()
    {
        return this.name;
    }
    public String getColor()
    {
        return this.color;
    }
}
