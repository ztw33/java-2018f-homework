package creature.devil;

import creature.Creature;

public class Snake extends Creature {

    private static int allNum = 0;

    public Snake() {

        if (allNum != 0)
            System.out.println("出事了，Snake有了");
        else {
            allNum++;
            coorX = coorY = -1;
            name = "Snake";
            symbolForCrea = 's';
            kind = false;
            System.out.println(this.getName() + " success");
        }

    }

}
