package formation;

import creature.Creature;
import field.BattleField;

public class Formation {
    int row;
    int column;
    BattleField field;
    public Formation(int row,int column){
        this.row=row;
        this.column=column;
        field=new BattleField(row,column);
    }
    public Formation(){
        this(20,6);
    }
    public BattleField embattle(Creature[] creatures) {
        return field;
    }
}
