public enum Huluwa {
    RED(1, "老大", "红"), ORANGE(2, "老二", "橙"), YELLOW(3, "老三", "黄"), GREEN(4, "老四", "绿"), INDIGO(5, "老五", "青"), BLUE(6, "老六", "蓝"), PURPLE(7, "老七", "紫");

    private int num;
    private String name;
    private String color;

    Huluwa(int num, String name, String color) {
        this.num = num;
        this.name = name;
        this.color = color;
    }

    public void ColorOff() {
        System.out.print(color);
    }

    public int getNum() {
        return num;
    }
}
