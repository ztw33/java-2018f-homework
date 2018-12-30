package creature.justice;

import creature.Creature;

public class Grandfather extends Creature {

    private static int allNum = 0;

    public Grandfather() {
        if (allNum != 0) {
            System.out.println("出事了，爷爷有了");
        } else {
            allNum++;
            coorX = coorY = -1;//初始坐标制定为-1
            name = this.getClass().getName();
            symbolForCrea = '8';
            kind = true;
            System.out.println(this.getName() + " success");
        }
    }
}