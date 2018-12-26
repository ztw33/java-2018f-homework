package hw3.creature;
import hw3.Cheerable;

public class Grandpa implements Creature, Cheerable {
    public String printName() {
        return "爷爷";
    }

    public void cheer() {
        System.out.println("爷爷为葫芦娃们加油");
    }
}
