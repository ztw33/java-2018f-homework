public enum CalabashBrotherEnum {
    RED("老大","红色",1),
    ORANGE("老二","橙色",2),
    YELLOW("老三","黄色",3),
    GREEN("老四","绿色",4),
    CYAN("老五","青色",5),
    BLUE("老六","蓝色",6),
    PURPLE("老七","紫色",7);

    public String name;
    public String color;
    public int index;

    CalabashBrotherEnum(String name, String color, int index){
        this.name = name;
        this.color = color;
        this.index = index;
    }
    public String tellColor(){
        return this.color;
    }
}
