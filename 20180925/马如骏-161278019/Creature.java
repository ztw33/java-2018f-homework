public abstract class Creature implements TellName {
    public Position position = new Position(-1,-1,this);
    public String name;

    public String tellSomething(String words ){
        return words;
    }

    public String tellName(){
        return this.name;
    }
}
