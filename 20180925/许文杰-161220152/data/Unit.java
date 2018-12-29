package data;

interface leader
{
    void cheer();
}

abstract public class Unit {
    private int x;
    private int y;
    Unit()
    {
        x = -1;
        y = -1;
    }
    void set(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    int getX(){ return x; }
    int getY(){ return y; }
    public abstract String getName();
}








