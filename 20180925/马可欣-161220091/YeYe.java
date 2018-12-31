public class YeYe {
    private int x;
    private int y;
    private String name;

    public YeYe() {
        this.x = 0;
        this.y = 1;
        this.name="老爷爷";
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

