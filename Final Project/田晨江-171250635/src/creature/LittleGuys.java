package creature;

public class LittleGuys extends Creature {

    private LittleGuys littleGuys;
    private Creature[] lg;

    public Creature[] createLittleGuys(int num){
        lg = new Creature[num+1];
        for(int i=0; i<num; i++){
            lg[i]= new LittleGuys();
        }
        lg[num]=new ScorpionEssence();
        return lg;
    }

    public void setLg(Creature[] lg) {
        this.lg = lg;
    }

    public Creature[] getLg() {
        return lg;
    }


    @Override
    public String toString() {
        return "小喽啰";
    }
}
