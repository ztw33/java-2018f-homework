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

class Grandpa extends Unit implements leader
{
    private String name;
    Grandpa()
    {
        name = "爷爷";
    }
    public String getName(){ return name; }
    public void cheer(){
        System.out.println("爷爷：加油！");
    };
}

class Snake extends Unit implements leader
{
    private String name;
    Snake()
    {
        name = "蛇精";
    }
    public String getName(){ return name; }
    public void cheer(){
        System.out.println("蛇精：加油！");
    };
}

class Scorpion extends Unit
{
    private String name;
    Scorpion()
    {
        name = "蝎子";
    }
    public String getName(){ return name; }
}

class Monster extends Unit
{
    private String name;
    Monster()
    {
        name = "喽啰";
    }
    public String getName() { return name; }
}

class CalaBashBrother extends Unit
{
    private int number;
    private String name;
    private String color;
    CalaBashBrother(int number, String name, String color)
    {
        this.number = number;
        this.name = name;
        this.color = color;
    }
    public int getNumber() { return number; }
    public String getName() { return name; }
    public String getColor() { return color; }
}
