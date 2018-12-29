package creature;

public class CalabashBrother extends Creature {
    private String color;
    private int rank;

    public CalabashBrother(int CBindex){
        super(CBEnum.values()[CBindex-1].getName(),CBEnum.values()[CBindex-1].getImage());
        this.color=CBEnum.values()[CBindex-1].getColor();
        this.rank=CBindex;
    }

    public String getColor(){
        return this.color;
    }
    public int getRank(){
        return rank;
    }

}
