import java.util.Random;

public enum Huluwa {
    RED(1, "老大", "红色"), ORANGE(2, "老二", "橙色"), YELLOW(3, "老三", "黄色"), GREEN(4, "老四", "绿色"), INDIGO(5, "老五", "青色"), BLUE(6, "老六", "蓝色"), PURPLE(7, "老七", "紫色");

    private int num;
    private String name;
    private String color;

    private Huluwa(int num, String name, String color) {
        this.num = num;
        this.name = name;
        this.color = color;
    }

    public void NumberOff() {
        System.out.print(name);
    }

    public int getNum() {
        return num;
    }

    public void ColorOff() {
        System.out.print(color);
    }

    public void move(int i, int j) {
        System.out.println(name + "：" + i + "->" + j);
    }
}


