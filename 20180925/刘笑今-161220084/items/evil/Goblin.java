package items.evil;

import items.Creature;

public class Goblin extends Creature {
    private static int globalnums = 0;

    public Goblin() {
        if (globalnums >= 20) {
            System.out.println("There can only exist 20 less Goblins...!");
            reportCreateFailed();
        } else {
            globalnums++;
            x = y = -1;
            name = "Goblin";
            identifier = '+';
            faction=false;
        }
    }
}
