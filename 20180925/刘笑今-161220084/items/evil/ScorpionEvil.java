package items.evil;

import items.Creature;

public class ScorpionEvil extends Creature {
    private static int globalnums = 0;

    public ScorpionEvil() {
        if (globalnums != 0) {
            System.out.println("SnakeEvil has been created...!");
            reportCreateFailed();
        } else {
            globalnums++;
            x = y = -1;
            name = "SnakeEvil";
            identifier = '^';
            faction=false;
        }
    }
}
