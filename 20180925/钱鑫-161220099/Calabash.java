package qx2;

public class Calabash extends Creature{
    private int rank;
    public Calabash(int rank)
    {
        this.rank=rank;
        switch(rank)
        {
            case 1:setName("老大");break;
            case 2:setName("老二");break;
            case 3:setName("老三");break;
            case 4:setName("老四");break;
            case 5:setName("老五");break;
            case 6:setName("老六");break;
            case 7:setName("老七");break;
            default:System.out.print("没有这个葫芦娃！！！");break;
        }
    }
    public int getRank()
    {
        return rank;
    }
}
