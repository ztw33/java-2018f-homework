enum Color{red,orange,yellow,green,ching,blue,purple}
enum Order{老大,老二,老三,老四,老五,老六,老七}
public class Hulu {
    int num;//排行
    Color color;
    Order order;
    public Color getColor() {
        return color;
    }

    public int getNum() {
        return num;
    }

    public Order getOrder() {
        return order;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
