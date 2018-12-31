package battleInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:39
 */

import creatureInformation.Creature;
import creatureInformation.Monster;
import creatureInformation.MonsterEnum;

public class EvilSide extends Sides{
    private int numOfMonsters;

    public EvilSide(int n) {
        this.side = 1;
        this.numOfMonsters = n;
        this.encouragement = new Monster(MonsterEnum.snake);
        this.creatures = new Monster[n];
        this.creatures[0] = new Monster(MonsterEnum.scorpion);
        for(int i = 1; i < numOfMonsters; i++)
            this.creatures[i] = new Monster(MonsterEnum.underlings);
        formation.board.setCreatureOnPosition(formation.board.getN()-1,formation.board.getN()-1,this.encouragement);
    }

    public Creature getSnake() {
        return encouragement;
    }

    public Creature[] getCreatures() {
        return creatures;
    }
}
