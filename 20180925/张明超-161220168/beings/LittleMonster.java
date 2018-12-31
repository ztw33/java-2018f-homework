package beings;

public class LittleMonster extends EvilParty{
    public LittleMonster(){
        name = "小喽啰";
    }
    @Override
    public void toldname(){
        System.out.print("|"+name);
    }
}