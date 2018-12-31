package renyi;

public class Brothers extends Creature{
    Brothers(int number,int x,int y)
    {
        this.x=x;
        this.y=y;
        if(number==1)
            this.name="老大";
        else if (number==2)
            this.name="老二";
        else if (number==3)
            this.name="老三";
        else if (number==4)
            this.name="老四";
        else if (number==5)
            this.name="老五";
        else if (number==6)
            this.name="老六";
        else if (number==7)
            this.name="老幺";
    }
}
