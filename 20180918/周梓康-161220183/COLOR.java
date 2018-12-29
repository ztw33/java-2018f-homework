public enum COLOR {

    RED("红色"), ORANGE("橙色"), YELLOW("黄色"), GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), PURPLE("紫色");

    private String color;

    COLOR(String color) {
        this.color = color;
    }

    public String getName() {
        return color;
    }
}