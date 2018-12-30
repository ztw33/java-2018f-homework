public class CalabashBoy {
    private String name;
    private Color color;
    private int order;
    public CalabashBoy(int boynum)
    {
        switch(boynum)
        {
            case 1:
                name = "老大";
                order = 1;
                color = Color.Red;
                break;
            case 2:
                name = "老二";
                order = 2;
                color = Color.Orange;
                break;
            case 3:
                name = "老三";
                order = 3;
                color = Color.Yellow;
                break;
            case 4:
                name = "老四";
                order = 4;
                color = Color.Green;
                break;
            case 5:
                name = "老五";
                order = 5;
                color = Color.Cyan;
                break;
            case 6:
                name = "老六";
                order = 6;
                color = Color.Blue;
                break;
            case 7:
                name = "老七";
                order = 7;
                color = Color.Purple;
                break;
            default:
                break;
        }
    }
    public CalabashBoy(CalabashBoy aim)
    {
        name = aim.name;
        order = aim.order;
        color = aim.color;
    }
    public String getName()
    {
        return name;
    }
    public Color getColor()
    {
        return color;
    }
    public String getColorName()
    {
        String colorname = "七色";
        switch(color.ordinal())
        {
            case 0:
                colorname = "红色";
                break;
            case 1:
                colorname = "橙色";
                break;
            case 2:
                colorname = "黄色";
                break;
            case 3:
                colorname = "绿色";
                break;
            case 4:
                colorname = "青色";
                break;
            case 5:
                colorname = "蓝色";
                break;
            case 6:
                colorname = "紫色";
                break;
            default:
                break;
        }
        return colorname;
    }
    public int getOrder()
    {
        return order;
    }
    public int CompareOrder(CalabashBoy Boy)
    {
        if(order < Boy.order)
            return -1;
        else if(order == Boy.order)
            return 0;
        else
            return 1;
    }
    public int CompareColor(CalabashBoy Boy)
    {
        if(color.ordinal() < Boy.color.ordinal())
            return -1;
        else if(color.ordinal() == Boy.color.ordinal())
            return 0;
        else
            return 1;
    }
    public void Copy(CalabashBoy aim)
    {
        name = aim.name;
        order = aim.order;
        color = aim.color;
    }
}
