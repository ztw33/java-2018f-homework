package items;

public abstract class Creature {
    protected int x;
    protected int y;
    protected String name;
    protected char identifier;
    //Faction: Justice(TRUE) or Evil(FALSE)
    protected boolean faction;

    public void moveToLocation(int x, int y){
        this.x=x;
        this.y=y;
        System.out.println(name+ "reports: "+name + "move to location (" + x + "," + y  +")");
    }

    public  int reportLocationX(){
        return x;
    }
    public int reportLocationY(){
        return y;
    }
    public String reportName(){
        return name;
    }
    public char reportIdentifier(){
        return identifier;
    }

    protected void reportCreateFailed(){
        System.out.println("Creature create failed: The specific object has been created or the number reaches upper bound.");
    }
}

