public class HuLuWa extends Creature {
    private int rank;
    public HuLuWa(String name,int rank){
        super(CreatureType.HULU,name);
        this.rank = rank;
    }
    public int getrank(){
        return rank;
    }
}
