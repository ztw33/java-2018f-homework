public class CalabashBrother extends Creature {
    private CalabashBrotherEnum thisCalabashBrother;

    public CalabashBrother(CalabashBrotherEnum oneCalabashBrother){
        this.thisCalabashBrother = oneCalabashBrother;
    }
    @Override
    public String tellName() {
        return this.thisCalabashBrother.name;
    }

}
