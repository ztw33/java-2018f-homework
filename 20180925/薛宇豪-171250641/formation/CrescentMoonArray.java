package formation;

import creature.Creature;
import field.BattleField;

public class CrescentMoonArray extends Formation {
    public CrescentMoonArray(int row, int column) {
        super(row,column);
    }
    public BattleField embattle(Creature[] creatures) {
        Creature[] newRoles=new Creature[18];
        if(creatures.length<18){
            for(int i=0;i<creatures.length;i++){
                newRoles[i]=creatures[i];
            }
            for(int i=creatures.length;i<18;i++){
                newRoles[i]=creatures[creatures.length-1];
            }
        }else{
            for(int i=0;i<18;i++){
                newRoles[i]=creatures[i];
            }
        }
        if (row < 7 || column < 4) {
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        } else {
            int vacancyRow = (row - 7) / 2;
            int vacancyColumn = (column - 4) / 2;
            for(int i=0;i<3;i++){
                field.battlefield[vacancyRow+2+i][vacancyColumn].setCreature(newRoles[i]);
                field.battlefield[vacancyRow+2+i][vacancyColumn+1].setCreature(newRoles[3+i]);
            }
            for(int i=0;i<5;i++){
                field.battlefield[vacancyRow+1+i][vacancyColumn+2].setCreature(newRoles[6+i]);
            }
            for(int i=0;i<7;i++){
                field.battlefield[vacancyRow+i][vacancyColumn+3].setCreature(newRoles[11+i]);
            }
        }
        return field;
    }
}
