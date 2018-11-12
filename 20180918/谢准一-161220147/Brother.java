enum Color {
    RED("红色", 1), ORANGE("橙色", 2), YELLOW("黄色", 3), GREEN("绿色", 4), CYAN("青色", 5), BLUE("蓝色", 6), PUEPLE("紫色", 7);
    private String color;
    private int index;
    private Color(String color, int i){
        this.color = color;
        this.index = i;
    }
    public String get_color() {
        return color;
    }
    public int get_index() {
        return index;
    }
} ;
public class Brother {
    String name;
    int rank;
    Color COLOR;
    Brother(int b_rank) {
        rank = b_rank;
        switch (b_rank) {
            case 1:name = "老大";COLOR = Color.RED;break;
            case 2:name = "老二";COLOR = Color.ORANGE;break;
            case 3:name = "老三";COLOR = Color.YELLOW;break;
            case 4:name = "老四";COLOR = Color.GREEN;break;
            case 5:name = "老五";COLOR = Color.CYAN;break;
            case 6:name = "老六";COLOR = Color.BLUE;break;
            case 7:name = "老七";COLOR = Color.PUEPLE;break;
        }
    }
    public void report_color() {
        System.out.print(COLOR.get_color());
    }
    public void report_name() {
        System.out.print(name);
    }
    public void exchange_place(int i, int j) {
        System.out.println(name + ": " + i + "->" + j);
    }
    public int get_color_rank(){
        return COLOR.get_index();
    }
}
