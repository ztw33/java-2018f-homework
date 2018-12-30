package battle;

import being.*;
import common.*;
import factory.EvilFactory;
import formation.*;
import position.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 万物始祖，一切战斗情节的控制器
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class BattleCoordinator implements BattleGoOn {

    @SuppressWarnings("unchecked")
    public List<BattleFieldLattice> oneRandomFormation() {
        BattleField<CartoonCharacter> battleField = new BattleField<>();
        Formation evilFormation = CreateFormation.createRandomFormationArray(new EvilFactory()).get(0);
        Formation justiceFormation = new ChangShe<>(new Justice());
        JusticeAndEvilPosition newPosition = CreateRandomPosition.createRandomPosition(evilFormation, justiceFormation);
        evilFormation.changeFormation(newPosition.evilPosition, battleField);
        justiceFormation.changeFormation(newPosition.justicePosition, battleField);
        return battleField.getBattleFieldLatticeArray();
    }

    @SuppressWarnings("unchecked")
    public List<BattleFieldLattice> oneSpecifiedFormation(FormationType formationType) {
        BattleField<CartoonCharacter> battleField = new BattleField<>();
        Formation evilFormation = CreateFormation.createSpecifiedFormation(formationType, new EvilFactory());
        Formation justiceFormation = new ChangShe<>(new Justice());
        JusticeAndEvilPosition newPosition = CreateRandomPosition.createRandomPosition(evilFormation, justiceFormation);
        evilFormation.changeFormation(newPosition.evilPosition, battleField);
        justiceFormation.changeFormation(newPosition.justicePosition, battleField);
        return battleField.getBattleFieldLatticeArray();
    }

    @SuppressWarnings("unchecked")
    public List<List<BattleFieldLattice>> groupRandomFormation() {
        List<List<BattleFieldLattice>> formationGroup = new ArrayList<>();
        BattleField<CartoonCharacter> battleField = new BattleField<>();
        List<Formation> evilFormation = CreateFormation.createRandomFormationArray(new EvilFactory());
        for (int j = 0; j < evilFormation.size(); j++) {
            Formation justiceFormation = new ChangShe<>(new Justice());
            JusticeAndEvilPosition newPosition = CreateRandomPosition.createRandomPosition(evilFormation.get(j), justiceFormation);
            evilFormation.get(j).changeFormation(newPosition.evilPosition, battleField);
            justiceFormation.changeFormation(newPosition.justicePosition, battleField);
            formationGroup.add(battleField.getBattleFieldLatticeArray());
        }
        return formationGroup;
    }

//    static final int MAX_LOOP_COUNT = 1;

//    public static void main(String[] args) {
//        BattleGoOn();
//    }

//    public static void BattleGoOn() {
//
//        BattleField<CartoonCharacter> battleField = new BattleField<>();
//        BattleFieldDisplay battleFieldDisplay = new BattleFieldDisplay();
//        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
//            List<Formation> evilFormation = CreateFormation.createRandomFormationArray(new EvilFactory());
//            for (int j = 0; j < evilFormation.size(); j++) {
//                Formation justiceFormation = new ChangShe<>(new Justice());
//                JusticeAndEvilPosition newPosition = CreateRandomPosition.createRandomPosition(evilFormation.get(j), justiceFormation);
//                evilFormation.get(j).changeFormation(newPosition.evilPosition, battleField);
//                justiceFormation.changeFormation(newPosition.justicePosition, battleField);
//                battleFieldDisplay.display(battleField);
//                battleField.clearBattleField();
//            }
//        }
//    }
}
