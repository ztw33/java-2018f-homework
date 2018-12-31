package renyi2;

public class Brothers extends Creature{
    Brothers(int number,int x,int y)
    {
        super("/Image/"+number+".png");
        this.Imageurl="/Image/"+number+".png";
        this.x=x;
        this.y=y;
        switch(number)
        {
            case 1:this.name="老大";break;
            case 2:this.name="老二";break;
            case 3:this.name="老三";break;
            case 4:this.name="老四";break;
            case 5:this.name="老五";break;
            case 6:this.name="老六";break;
            case 7:this.name="老幺";break;
            default:break;
        }
    }
}