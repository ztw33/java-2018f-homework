package items.calabash;

import items.Creature;

public class CalabashBro extends Creature {
    private static int globalnums = 0;

    public CalabashBro() {
        if (globalnums >= 7) {
            System.out.println("There can only exist 7 less Calabash Bros...!");
            reportCreateFailed();
        } else {
            globalnums++;
            x = y = -1;
            name = CalabashDict.getNameFromRank(globalnums);
            identifier = (char)((int)'0' + globalnums);
            faction=true;
        }
    }
}
