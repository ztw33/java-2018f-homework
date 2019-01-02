package beings;

public class Being {
    public Being(){

    }
    public void toldname() {
        System.out.print(name);
    }
    public int getPositionx(){
        return positionx;
    }
    public int getPositiony(){
        return positiony;
    }

    public void setPosition(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
    }

    protected String name;
    protected int positionx = 0;
    protected int positiony = 0;
}
