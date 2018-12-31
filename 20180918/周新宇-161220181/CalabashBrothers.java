enum COLOR {undefined, red, orange, yellow, green, cyan, blue, purple}

public class CalabashBrothers {
    String name;
    COLOR color;
    int FamilyRank;
    CalabashBrothers()
    {
        name = new String("Unknown");
        color = COLOR.undefined;
        FamilyRank = -1;
    }

    public void TellMyName()
    {
        System.out.println(name);
    }
    public void TellMyColor()
    {
        switch(color)
        {
            case red:System.out.println("红色");break;
            case orange:System.out.println("橙色");break;
            case yellow:System.out.println("黄色");break;
            case green:System.out.println("绿色");break;
            case cyan:System.out.println("青色");break;
            case blue:System.out.println("蓝色");break;
            case purple:System.out.println("紫色");break;
            default:System.out.println("未知颜色");break;
        }
    }
    public void TellPositionChange(int past,int now)
    {
        System.out.println(name + ": " + past + "->" + now);
    }
}

