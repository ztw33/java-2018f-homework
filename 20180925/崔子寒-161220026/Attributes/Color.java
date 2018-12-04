package Attributes;
public enum Color {
    RED("大娃"), ORANGE("二娃"), YELLOW("三娃"), GREEN("四娃"),
    CYAN("五娃"), BLUE("六娃"), PURPLE("七娃");

    final private  String name;
    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
