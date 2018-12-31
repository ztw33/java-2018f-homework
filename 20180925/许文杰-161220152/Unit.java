public class Unit {
    private int x;
    private int y;
    private String name;
    //Unit(String name)
    //{
    //    this.name = name;
    //}
    public void set(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public String getName(){ return name; }
}

class Grandpa extends Unit
{
    private String name;
    Grandpa()
    {
       name = "爷爷";
    }
    @Override
    public String getName(){ return name; }
}

class Scorpion extends Unit
{
    private String name;
    Scorpion()
    {
        name = "蝎子";
    }
    @Override public String getName(){ return name; }
}

class Snake extends Unit
{
    private String name;
    Snake()
    {
        name = "蛇精";
    }
    @Override public String getName(){ return name; }
}

class Monster extends Unit
{
    private String name;
    Monster()
    {
        name = "喽啰";
    }
    @Override public String getName() { return name; }
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
    @Override public String getName() { return name; }
    public String getColor() { return color; }
}

