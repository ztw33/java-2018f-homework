package logic.battleInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 22:14
 */

import logic.creatureInformation.Creature;

import java.util.ArrayList;

public class Sides <T>{
    public static Formation formation;
    int side;
    ArrayList<Creature<T>> creatures;
    Creature<T> encouragement;//鼓励师
    public void changeFormation(String name){
        int y = 0;
        if (side == 1){
            y = formation.board.getSIZE() / 2;
        }
        switch (name){
            case "snake":formation.snakeFormation(this, (formation.board.getSIZE() - creatures.size()) / 2, 1 + y);break;
            case "goose":formation.gooseFormation(this, (formation.board.getSIZE() - creatures.size()) / 2,
                    y * 2 - 1 + (formation.board.getSIZE() / 2 - creatures.size()) / 2);break;
            case "flank":formation.flankFormation(this, formation.board.getSIZE() / 2,
                    y + y / 3);
        }
    }
}
