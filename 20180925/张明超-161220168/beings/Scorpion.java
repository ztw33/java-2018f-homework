package beings;

public class Scorpion extends EvilParty{
    public Scorpion(){
        name = "蝎子精";
    }
    @Override
    public void toldname(){
        System.out.print("|"+name);
    }
}