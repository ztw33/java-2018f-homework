public interface Leader extends Creature{
    void order(FormationType formationType);
    void move(int x1, int y1, int x2, int y2);
    void greet();
    void view();
    void setMoveDevice(MoveDevice moveDevice);
    void setOrderDevice(OrderDevice orderDevice);
    void setViewDevice(ViewDvice viewDevice);
}
