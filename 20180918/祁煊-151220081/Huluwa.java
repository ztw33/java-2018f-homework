
public class Huluwa {

    private int id;
    private String name;
    private String color;

    // 构造函数
    Huluwa(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    // 获取某只葫芦娃的序号
    public int getNo() {
        return id;
    }

    // 获取某只葫芦娃的名字
    public String getName() {
        return name;
    }

    // 获取某只葫芦娃的颜色
    public String getColor() {
        return color;
    }

}
