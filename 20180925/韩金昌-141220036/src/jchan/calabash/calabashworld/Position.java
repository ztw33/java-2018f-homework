package jchan.calabash.calabashworld;

public class Position {
    private double x;
    private double y;
    private double z;
    private int locationx = (int)x;
    private int locationy = (int)y;
    private int locationz = (int)z;
    protected void setPoint(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
        locationx = (int) x;
        locationy = (int) y;
        locationz = (int) z;
    }
    protected void setPointx(double x){
        this.x = x;
        locationx = (int) x;
    }
    protected void setPointy(double y){
        this.y = y;
        locationy = (int) y;
    }
    protected void setPointz(double z){
        this.z = z;
        locationz = (int) z;
    }

    public int getLocationx() {
        return locationx;
    }

    public int getLocationy() {
        return locationy;
    }
    public int getLocationz() {
        return locationz;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}

