package com.company.Formation;
import com.company.BattleField.BattleField;
import com.company.Being.*;

import com.company.Being.CalabashBrother;
import com.company.Coordinate.Coordinate;
public interface Formation {
    void setBeing(BattleField field, CalabashBrother[] brother);
    void setBeing(BattleField field,Minion[] minion);
}
