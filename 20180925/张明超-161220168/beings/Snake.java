package beings;

public class Snake extends EvilParty implements Cheer{
    public Snake(){
        name = "蛇精";
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
