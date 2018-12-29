package beings;

public enum Color{
    RED("老大","红色"),ORANGE("老二","橙色"),YELLOW("老三","黄色"),GREEN("老四","绿色"),
    CYAN("老五","青色"),BLUE("老六","蓝色"),PURPLE("老七","紫色");
    private final String name;
    private final String color;
    Color(String name, String color){
        this.color = color;
        this.name = name;
    }
    public String getColor(){
        return color;
    }
    public String getName(){
        return name;
    }
}