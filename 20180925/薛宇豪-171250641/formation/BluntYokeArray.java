package formation;

import creature.Creature;
import field.BattleField;

public class BluntYokeArray extends Formation {
    public BluntYokeArray(int row, int column) {
        super(row,column);
    }
    public BattleField embattle(Creature[] creatures){
        int numOfPeople=creatures.length;
        int aimedColumn=column/2;
        int allRow=numOfPeople;
        if(allRow>row || column<2){
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        }else {
            int vacancyRow = (row - allRow) / 2;
            for(int i=0;i<(numOfPeople+1)/2;i++){
                field.battlefield[vacancyRow+2*i][aimedColumn-1].setCreature(creatures[2*i]);
            }
            for (int i=0;i<numOfPeople/2;i++){
                field.battlefield[vacancyRow+2*i+1][aimedColumn].setCreature(creatures[2*i+1]);
            }
        }
        return field;
    }
}
