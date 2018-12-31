package creature.devil;

import creature.Creature;

public class Mobs extends Creature {

    private static int allNum = 0;


    public Mobs() {

        if (allNum >= 10)//数量上限定为10
            System.out.println("出事了，Mobs多了");
        else {
            allNum++;
            coorX = coorY = -1;
            name = "Mob";
            symbolForCrea = 'm';
            kind = false;
            System.out.println(this.getName() + " success");
        }
    }
}
