public class JusticeLeague extends League {
//    public int TOTAL_NUMBER = 8;
//
    public leader justiceLeader = new Grandpa();

    public class Grandpa extends leader{
        private Grandpa(){
            this.name = "爷爷";
        }
    }
    public JusticeLeague(){
        this.NUMBER = 7;
        this.creatures = new Creature[7];
        for(int i=0;i<7;i++){
            this.creatures[i] = new CalabashBrother(CalabashBrotherEnum.values()[i]);
        }
    }
}
