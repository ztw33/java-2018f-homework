public class Grandpa implements Leader {

    MoveDevice moveDevice;
    OrderDevice orderDevice;
    ViewDvice viewDevice;

    public void print(){
        System.out.print("爷");
    }


    @Override
    public void setMoveDevice(MoveDevice moveDevice) {
        this.moveDevice = moveDevice;
    }

    @Override
    public void setOrderDevice(OrderDevice orderDevice) {
        this.orderDevice = orderDevice;
    }
    @Override
    public void setViewDevice(ViewDvice viewDvice) {
        this.viewDevice = viewDvice;
    }

    @Override
    public void move(int x1, int y1, int x2, int y2) {
        moveDevice.moveMethod(x1, y1, x2, y2);
    }

    public void order(FormationType formationType) {
        orderDevice.orderMethod(formationType);
    }

    @Override
    public void greet() {

    }

    @Override
    public void view() {
        viewDevice.viewMethod();
    }
}
