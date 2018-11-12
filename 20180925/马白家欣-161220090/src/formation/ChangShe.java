package com.homework3.formation;

import com.homework3.being.*;
import com.homework3.battle.BattleField;
import com.homework3.coordinate.Position;

/**
 * @Description 长蛇
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class ChangShe extends Formation {
    public ChangShe() {
        super(0, 6, 2, 0);
    }

    public void changeFormation(Position position, BattleField battleField, CartoonCharacter cartoonCharacter) {

        fillBattleFiled(battleField, position, cartoonCharacter);
    }

    private static void fillBattleFiled(BattleField battleField, Position position, CartoonCharacter cartoonCharacter)
    {
        if(cartoonCharacter instanceof Justice)
        {
            battleField.setBattleFieldLattice(position, new Red());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new Orange());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new Yellow());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new Green());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new Cyan());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new Blue());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new Purple());
            position.move(-3, -2);
            battleField.setBattleFieldLattice(position, new Grandfather());
        }
        else if(cartoonCharacter instanceof Evil){
            battleField.setBattleFieldLattice(position, new LowLevelDemon());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new LowLevelDemon());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new LowLevelDemon());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new Scorpion());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new LowLevelDemon());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new LowLevelDemon());
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, new LowLevelDemon());
            position.move(-3, -2);
            battleField.setBattleFieldLattice(position, new Snake());
        }
        else {
            assert false;
        }
    }
}
