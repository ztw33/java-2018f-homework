package MotherEarthPack.Scientific;

public class Coordinate   // 坐标
{
    private static final int unDefinedLocation = -1;

    private int r;
    private int c;

    public Coordinate(){
        r = unDefinedLocation;
        c = unDefinedLocation;
    }

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public int getR() {
        return r;
    }

    public int getManhattanDistance(Coordinate coordinate) {
        return Math.abs(r - coordinate.getR()) + Math.abs(c - coordinate.getC());
    }

    public void toUpperLeft() {
        r -= 1;
        c -= 1;
    }

    public void toUpperRight() {
        r -= 1;
        c += 1;
    }

    public void toLowerLeft() {
        r += 1;
        c -= 1;
    }

    public void toLowerRight() {
        r += 1;
        c += 1;
    }

    public void toUp() { r -= 1; }

    public void toDown() { r += 1; }

    public void toLeft() { c -= 1; }

    public void toRight() { c += 1; }

    public boolean haveSet()
    {
        if((r == unDefinedLocation)&&(c == unDefinedLocation))
            return false;
        return true;
    }
}

