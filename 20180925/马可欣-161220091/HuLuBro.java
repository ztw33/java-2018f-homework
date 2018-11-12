public enum HuLuBro {
    RED("红色", "老大"), ORANGE("橙色", "老二"), YELLOW("黄色", "老三"), GREEN("绿色", "老四"), CYAN("青色", "老五"), BLUE("蓝色", "老六"), PURPLE("紫色", "老七");
    private String color;
    private String name;
    private int x;
    private int y;

    private HuLuBro(String color, String name) {
        this.name = name;
        this.color = color;
        //初始化坐标
        this.x = this.ordinal() + 1;
        this.y = 3;
    }

    public boolean ifempty() {
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Space getSpace() {
        Space e = new Space(x, y);
        return e;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
