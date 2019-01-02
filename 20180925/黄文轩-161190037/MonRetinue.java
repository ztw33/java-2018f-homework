

class MonRetinue extends Creature{
    MonRetinue(int rank){
        super();
        this.type = CreatureType.valueOf("MonRetinue"+rank);
        this.name = this.type.name();

    }

    @Override
    public String toString(){
        return "小";
    }
}