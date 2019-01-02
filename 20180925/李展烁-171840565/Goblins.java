public class Goblins implements BadFollower{
    MoveDevice moveDevice;

    @Override
    public void setMoveDevice(MoveDevice moveDevice) {
        this.moveDevice = moveDevice;
    }

    @Override
    public void move(int x1, int y1, int x2, int y2) {
        moveDevice.moveMethod(x1, y1, x2, y2);
    }

    public void print(){
        System.out.print("喽");
    }

}
