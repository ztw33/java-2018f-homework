package HuluPack;

enum HuluBrotherType
{
    TypeOne("红娃","红色",1), TypeTwo("橙娃","橙色",2), TypeThree("黄娃","黄色",3),
    TypeFour("绿娃","绿色",4), TypeFive("青娃","青色",5), TypeSix("蓝娃","蓝色",6),
    TypeSeven("紫娃","紫色",7);

    private String name;
    private String color;
    private int rank;

    HuluBrotherType(String name, String color, int rank)
    {
        this.name = name;
        this.color = color;
        this.rank = rank;
    }

    public String getName()
    {
        return name;
    }
    public String getColor()
    {
        return color;
    }
    public int getRank()
    {
        return rank;
    }
}
