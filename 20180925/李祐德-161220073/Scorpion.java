public class Scorpion extends Organism {
    public enum enum_Scorpion {
        SCORPION("蝎精");
        String name;

        enum_Scorpion(String name) {
            this.name = name;
        }
    }

    private enum_Scorpion scorpion;
    Scorpion(){
        scorpion = enum_Scorpion.values()[0];
    }
    public String tellName(){ return scorpion.name; }
}