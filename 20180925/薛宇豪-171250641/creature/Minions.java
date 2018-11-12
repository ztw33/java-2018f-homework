package creature;

public class Minions extends Demon implements Fight {
    public Minions(){
        super("小喽啰",'#');
    }

    @Override
    public void fight() {
        //nothing to do
    }
}
