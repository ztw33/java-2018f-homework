public class SJ {
    private int x;
    private int y;
    private String name;

    public SJ() {
        this.x = 3;
        this.y = 18;
        this.name="蛇精";
    }

    public String getName() {
        return this.name;
    }

    public void setIt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        //System.out.print("x:" + x + " ");
        return x;
    }

    public int getY() {
        //System.out.print("y:" + y + " ");
        return y;
    }

    public Space getSpace() {
        Space e = new Space(x, y);
        return e;
    }

}
