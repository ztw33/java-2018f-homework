public class creatures
{
    String name;
    int x;
    int y;
    creatures()
    {
        x=y=0;
        name=new String("*");
    }
    creatures(int get_x,int get_y)
    {
        name=new String("*");
        x=get_x;
        y=get_y;
    }
    public void show_pos() {
        System.out.println("("+x+","+y+")");
    }
}