package battleInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 22:14
 */

import creatureInformation.Creature;

public class Sides {
    public static Formation formation;
    int side;
    Creature[] creatures;
    Creature encouragement;//鼓励师
    public void changeFormation(String name){
        int y = 0;
        if (side == 1){
            y = formation.board.getN() / 2;
        }
        switch (name){
            case "snake":formation.snakeFormation(this, (formation.board.getN() - creatures.length) / 2, 1 + y);break;
            case "goose":formation.gooseFormation(this, (formation.board.getN() - creatures.length) / 2,
                    y * 2 - 1 + (formation.board.getN() / 2 - creatures.length) / 2);break;
            case "flank":formation.flankFormation(this, formation.board.getN() / 2,
                    y + y / 3);
        }
    }
}
