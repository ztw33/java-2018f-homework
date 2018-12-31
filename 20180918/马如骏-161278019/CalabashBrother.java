public enum CalabashBrother {
    RED("老大","红色",1),
    ORANGE("老二","橙色",2),
    YELLOW("老三","黄色",3),
    GREEN("老四","绿色",4),
    CYAN("老五","青色",5),
    BLUE("老六","蓝色",6),
    PURPLE("老七","紫色",7);

    private String name;
    private String color;
    public int index;
    public int position;

    CalabashBrother(String name, String color, int index){
        this.name = name;
        this.color = color;
        this.index = index;
    }
    public void move(int newPosition){
        System.out.print("****");
        System.out.print(this.name);
        System.out.print(":");
        System.out.print(this.position);
        System.out.print(" -> ");
        System.out.println(newPosition);
        this.position = newPosition;
    }
    public String tellName(){
        return name;
    }
    public String tellColor() {
        return color;
    }
//    public static void main(String[] args){
//        CalabashBrother a = RED;
//        System.out.print(a);
//        a.tellColor();
//        a.tellName();
//    }
}