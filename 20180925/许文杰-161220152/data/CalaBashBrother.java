package data;

public class CalaBashBrother extends Unit{
    private int number;
    private String name;
    private String color;
    public CalaBashBrother(int number, String name, String color)
    {
        this.number = number;
        this.name = name;
        this.color = color;
    }
    public int getNumber() { return number; }
    public String getName() { return name; }
    public String getColor() { return color; }
}
