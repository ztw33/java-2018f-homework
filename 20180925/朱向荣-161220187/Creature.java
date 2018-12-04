
public class Creature {
    private  CreatureType type;
    private String name;
    public Creature(CreatureType type,String name){
        this.type = type;
        this.name = name;
    }
    public CreatureType gettype(){
        return type;
    }
    public String getname(){
        return name;
    }
}
