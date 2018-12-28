package beings;

public class CalabashBrother extends JustParty{
    private Color selfColor;
    public CalabashBrother(int i){
        selfColor = Color.values()[i];
        name = selfColor.getName();
    }
    public String getName(){
        return selfColor.getName();
    }
    public int getRank(){
        return selfColor.ordinal();
    }
    @Override
    public void toldname(){
        System.out.print("|"+selfColor.getName()+"  " );
    }
}
