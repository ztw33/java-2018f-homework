
class MonScorpion extends Creature{
    MonScorpion(){
        super();
        this.type = CreatureType.MonScorpion;
        this.name = this.type.name();

    }

    @Override
    public String toString(){
        return "蝎";
    }
}
