package com.company.Formation;
import java.util.*;
import com.company.BattleField.BattleField;
import com.company.Being.Minion;
import com.company.Being.CalabashBrother;

public class ChangShe implements Formation {
    public void setBeing(BattleField field, CalabashBrother[] brother){
        for(int i=0;i<7;i++) {
            field.battlefield[9 + i][0].being = brother[i];
            field.battlefield[9 + i][0].isEmpty = false;
        }
    }
    public void setBeing(BattleField field,Minion[] minion){
        for(int i=0;i<7;i++){
            field.battlefield[9 + i][24].being = minion[i];
            field.battlefield[9 + i][24].isEmpty = false;
        }
    }
}
