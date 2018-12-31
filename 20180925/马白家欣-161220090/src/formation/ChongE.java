package com.homework3.formation;

import com.homework3.being.*;
import com.homework3.battle.BattleField;
import com.homework3.coordinate.Position;

/**
 * @Description 冲轭
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class ChongE extends Formation {
    public ChongE() {
        super(2, 3, 1, 2);
    }

    public void changeFormation(Position position, BattleField battleField, CartoonCharacter cartoonCharacter) {

        battleField.clearBattleField();
        fillBattleFiled(battleField, position, cartoonCharacter);
    }

    private void fillBattleFiled(BattleField battleField, Position position, CartoonCharacter cartoonCharacter)
    {
        if(cartoonCharacter instanceof Justice)
        {
            assert false;
        }
        battleField.setBattleFieldLattice(position, new Scorpion());
        position.move(0, 2);
        battleField.setBattleFieldLattice(position, new Snake());
        position.move(-1, -3);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
        position.move(-1, 1);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
        position.move(3, -1);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
        position.move(1, 1);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
        position.move(1, -1);
        battleField.setBattleFieldLattice(position, new LowLevelDemon());
    }
}
