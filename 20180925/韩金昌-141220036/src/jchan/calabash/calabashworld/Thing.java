package jchan.calabash.calabashworld;

public abstract class Thing {
    protected String name;
    protected Field field;
    protected Position position = new Position();
    //private or protected?

    public Thing(double x, double y, Field field){
        /*this.x = x;
        this.y = y;
        this.z = 0;
        locationx = (int)x;
        locationy = (int)y;
        locationz = (int)z;
        this.field = field;
        this.field[locationx][locationy][locationz].thing = this;
        this.field[locationx][locationy][locationz].exist = true; */
        this(x,y,0,field);
    }
    public Thing(double x, double y, double z, Field field){
        this.position.setPoint(x,y,z);
        this.field = field;
        //System.out.print(locationx);
        //System.out.print(locationy);
        //System.out.print(locationz);
        field.cells[position.getLocationx()][position.getLocationy()][position.getLocationz()].thing = this;
        field.cells[position.getLocationx()][position.getLocationy()][position.getLocationz()].exist = true;
    }
    public boolean isHere(int x,int y){
        return isHere(x,y,0);
    }
    public boolean isHere(int x,int y,int z){
        if(position.getLocationx() == x && position.getLocationy() == y && position.getLocationz() == z)
            return true;
        else
            return false;
    }
    public boolean isConflict(Thing thing){
        return this.isHere(thing.position.getLocationx(),thing.position.getLocationy(),thing.position.getLocationz());
    }
    private boolean xmove(double xplus){
        position.setPointx(xplus + position.getX());
        return true;
    }
    private boolean ymove(double yplus){
        position.setPointy(yplus + position.getY());
        return true;
    }
    private boolean zmove(double zplus){
        position.setPointz(zplus + position.getZ());
        return true;
    }
    public boolean move(double x,double y,double z){
        if(this.field.cells[(int)x][(int)y][(int)z].exist == true)
            return false;
        this.field.cells[getLocationx()][getLocationy()][getLocationz()].exist = false;
        position.setPoint(x,y,z);
        this.field.cells[getLocationx()][getLocationy()][getLocationz()].exist = true;
        this.field.cells[getLocationx()][getLocationy()][getLocationz()].thing = this;
        //System.out.println("moveto:"+locationx+','+locationy+','+locationz);
        return true;
    }
    public boolean exchange(double x,double y,double z){
        if(this.field.cells[(int)x][(int)y][(int)z].exist == true) {
            double x0 = this.position.getX();
            double y0 = this.position.getY();
            double z0 = this.position.getZ();
            int i = 0;
            int j = 0;
            int k = 0;
            for (; i < field.getxMax(); i++) {
                for (; j < field.getyMax(); j++) {
                    for (; k < field.getzMax(); k++) {
                        if (field.cells[i][j][k].exist == false)
                            break;
                    }
                    if (field.cells[i][j][k].exist == false)
                        break;
                }
                if (field.cells[i][j][k].exist == false)
                    break;
            }
            this.field.cells[(int) x][(int) y][(int) z].thing.move(i, j, k);
            move(x, y, z);
            this.field.cells[i][j][k].thing.move(x0, y0, z0);
            return true;
        }
        else{
            move(x,y,z);
            return false;
        }
    }
    public boolean move(double x,double y){
        return move(x,y,1);
    }

    public int getLocationx() {
        return position.getLocationx();
    }

    public int getLocationy() {
        return position.getLocationy();
    }

    public int getLocationz() {
        return position.getLocationz();
    }

    public double getX(){
        return position.getX();
    }
    public double getY(){
        return position.getY();
    }
    public double getZ(){
        return position.getZ();
    }
    public abstract char whoami();
}