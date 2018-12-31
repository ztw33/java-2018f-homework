package myfile;

public class Act {
    private String name;
    private int action;
    private boolean alive;
    private int sitex;
    private int sitey;
    public Act(String name,int action,boolean alive,int sitex,int sitey){
        this.name = name;
        this.action = action;
        this.alive = alive;
        this.sitex = sitex;
        this.sitey = sitey;
    }
    public String getName(){return name;}
    public int getAction(){return action;}
    public boolean getAlive(){return alive;}
    int getSitex(){return sitex;}
    int getSitey(){return sitey;}
}
