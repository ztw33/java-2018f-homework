package CalabashCreate.beings;

enum Color{红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色}
enum CalabashName{老大, 老二, 老三, 老四, 老五, 老六, 老七}

public class Calabash extends Sheep{
    public int rank;
    public Color color;
    public CalabashName name;
    public Calabash(int rank)
    {
        this.rank = rank;
        this.color = Color.values()[rank];
        this.name = CalabashName.values()[rank];
    }
}
