package homework3.creature;

public class Scorpion extends Monster {
    private static Scorpion scorpion = new Scorpion();

    private Scorpion(){
        name = "蝎";
    }

    public static Scorpion getInstance(){
        return scorpion;
    }
}
