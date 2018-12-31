package battleInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:19
 */

import creatureInformation.CalabashBrother;
import creatureInformation.CalabashBrotherEnum;
import creatureInformation.Creature;
import creatureInformation.GrandPa;

public class JustSide extends Sides{
    public JustSide() {
        this.side = 0;
        this.creatures = new CalabashBrother[7];
        int i = 0;
        for(CalabashBrotherEnum one : CalabashBrotherEnum.values()){
            creatures[i] = new CalabashBrother(one);
            i++;
        }
        this.encouragement = new GrandPa();
        formation.board.setCreatureOnPosition(0,0, this.encouragement);
    }

    public Creature[] getCalabashBrothers() {
        return creatures;
    }

    public Creature getEncouragement() {
        return this.encouragement;
    }
}
