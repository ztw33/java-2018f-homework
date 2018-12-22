public class Creature {

    private String name;
    private String type;

    // 构造函数
    Creature(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() { return type; }
}
