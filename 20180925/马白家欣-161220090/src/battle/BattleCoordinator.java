package com.homework3.battle;

import com.homework3.being.Evil;
import com.homework3.being.Justice;
import com.homework3.common.CreateRandomFormationObject;
import com.homework3.common.CreateRandomPositon;
import com.homework3.coordinate.JusticeAndEvilPosition;
import com.homework3.formation.*;
import com.homework3.output.BattleFieldDisplay;

/**
 * @Description 万物始祖，一切战斗情节的控制器
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class BattleCoordinator {

    static final int MAX_LOOP_COUNT = 10;

    public static void main(String[] args) {
        BattleGoOn();
    }

    public static void BattleGoOn() {

        BattleField battleField = new BattleField();
        BattleFieldDisplay battleFieldDisplay = new BattleFieldDisplay();
        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
            Formation evilFormation = CreateRandomFormationObject.createRandomFormationObject();
            Formation justiceFormation = new ChangShe();
            JusticeAndEvilPosition newPosition = CreateRandomPositon.createRandomPositon(evilFormation, new ChangShe());
            evilFormation.changeFormation(newPosition.evilPosition, battleField, new Evil(""));
            justiceFormation.changeFormation(newPosition.justicePosition, battleField, new Justice(""));
            battleFieldDisplay.display(battleField);
            battleField.clearBattleField();
        }
    }
}
