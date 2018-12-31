package com.homework3.formation;

import com.homework3.being.*;
import com.homework3.battle.BattleField;
import com.homework3.coordinate.Position;

/**
 * @Description 雁行
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class YanXing extends Formation {
    public YanXing() {
        super(2, 2, 2, 3);
    }

    public void changeFormation(Position position, BattleField battleField, CartoonCharacter cartoonCharacter) {

        battleField.clearBattleField();
        fillBattleFiled(battleField, position, cartoonCharacter);
    }

    private static void fillBattleFiled(BattleField battleField, Position position, CartoonCharacter cartoonCharacter)
    {
        if(cartoonCharacter instanceof Justice)
        {
            assert false;
        }
        battleField.setBattleFieldLattice(position, new Scorpion());
        position.move(0, 3);
        battleField.setBattleFieldLattice(position, new Snake());
        position.move(-1, -2);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
        position.move(-1, 1);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
        position.move(3, -3);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
        position.move(1, -1);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
    }
}
