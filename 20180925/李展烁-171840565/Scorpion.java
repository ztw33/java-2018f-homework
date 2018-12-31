public class Scorpion implements BadFollower {

    MoveDevice moveDevice;

    @Override
    public void setMoveDevice(MoveDevice moveDevice) {
        this.moveDevice = moveDevice;
    }

    public void print(){
        System.out.print("蝎");
    }

    @Override
    public void move(int x1, int y1, int x2, int y2) {
        moveDevice.moveMethod(x1, y1, x2, y2);
    }
}
