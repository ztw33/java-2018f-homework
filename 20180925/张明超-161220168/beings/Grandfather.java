package beings;

public class Grandfather extends JustParty implements Cheer{
    public Grandfather(){
        this.name = "爷爷";
    }
    @Override
    public void toldname(){
        System.out.print("|"+name+"  ");
    }
    @Override
    public void cheer(){
        ;
    }
}
