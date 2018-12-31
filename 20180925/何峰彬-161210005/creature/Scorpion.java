package homework3.creature;

public class Scorpion extends Creature {
    private static Scorpion scorpion = new Scorpion();

    private Scorpion(){
        super();
        name = "蝎";
    }

    public static Scorpion getInstance(){
        return scorpion;
    }
}
