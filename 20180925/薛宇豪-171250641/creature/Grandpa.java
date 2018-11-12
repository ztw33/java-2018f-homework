package creature;

public class Grandpa extends Creature implements Cheer {
    public Grandpa(){
        super("老爷爷",'&');
    }

    @Override
    public void cheer() {
        //nothing to do
    }
}
