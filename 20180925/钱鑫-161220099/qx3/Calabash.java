package qx3;

public class Calabash extends Creature{
    private int rank;
    public Calabash(int rank)
    {
        this.rank=rank;
        switch(rank)
        {
            case 1:
                setName("老大");
                setUrl("/picture/1.png");
                break;
            case 2:
                setName("老二");
                setUrl("/picture/2.png");
                break;
            case 3:
                setName("老三");
                setUrl("/picture/3.png");
                break;
            case 4:
                setName("老四");
                setUrl("/picture/4.png");
                break;
            case 5:
                setName("老五");
                setUrl("/picture/5.png");
                break;
            case 6:
                setName("老六");
                setUrl("/picture/6.png");
                break;
            case 7:
                setName("老七");
                setUrl("/picture/7.png");
                break;
            default:System.out.print("没有这个葫芦娃！！！");break;
        }
    }
    public int getRank()
    {
        return rank;
    }
}
