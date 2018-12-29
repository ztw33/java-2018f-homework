package creature;

public enum Color {

    RED("红色"), ORANGE("橙色"), YELLOW("黄色"), GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), PURPLE("紫色");

    private String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
