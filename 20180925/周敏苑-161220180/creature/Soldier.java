package creature;

public class Soldier implements Creature{
    private String name;
    private Position position;

    public Soldier(){;}
    public Soldier(String name){
        this.name = name;
    }
    public Soldier(Position p){
        this.position = p;
    }
    public Soldier(Position p, String name){this.position = p; this.name = name;}
    public void setPosition(Position t){
        this.position = t;
    }

    public Position getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name;
    }
}
