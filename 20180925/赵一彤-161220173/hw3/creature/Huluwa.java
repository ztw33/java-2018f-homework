package hw3.creature;

public class Huluwa implements Creature{
    private final String name;
    private final Color color;
    private final int rank;

    public Huluwa(int i) {
        name = HuluwaCategory.values()[i].getName();
        color = HuluwaCategory.values()[i].getColor();
        rank = i;
    }

    public String printName() {
        return name;
    }

    public int rank() {
        return rank;
    }
}
