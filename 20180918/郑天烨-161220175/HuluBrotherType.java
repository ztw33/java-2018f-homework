enum HuluBrotherType
{
    TypeOne("老大","红色",1), TypeTwo("老二","橙色",2), TypeThree("老三","黄色",3),
    TypeFour("老四","绿色",4), TypeFive("老五","青色",5), TypeSix("老六","蓝色",6),
    TypeSeven("老七","紫色",7);

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
