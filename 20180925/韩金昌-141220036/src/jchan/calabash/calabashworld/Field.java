package jchan.calabash.calabashworld;

public class Field {
    public final Cell[][][] cells;
    private int xMax;
    private int yMax;
    private int zMax;
    public Field(){
        this(20,20,1);
    }
    public Field(int x,int y){
        this(x,y,1);
    }
    public Field(int x,int y,int z){
        cells = new Cell[x][y][z];
        for(int i = 0;i < x;i++)
            for(int j = 0;j < y;j++)
                for(int k = 0;k < z;k++)
                {
                    cells[i][j][k] = new Cell((int)(Math.random() * 10));
                }
        this.xMax = x;
        this.yMax = y;
        this.zMax = z;
    }
    public int getxMax(){
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public int getzMax() {
        return zMax;
    }
}
