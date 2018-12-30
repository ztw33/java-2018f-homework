package creature;

public class Scorpion implements Creature{
    private String name;
    private Position position;

    public Scorpion(String name){
        this.name = name;
    }
    public void setPosition(Position t){
        position = t;
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
