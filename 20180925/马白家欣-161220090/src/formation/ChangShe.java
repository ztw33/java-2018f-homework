package formation;

import battle.BattleField;
import being.*;
import position.Position;

/**
 * @Description 长蛇
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class ChangShe <T extends CartoonCharacter> extends Formation<CartoonCharacter> {
    public ChangShe(T kind) {
        super(0, 6, 2, 0);
        this.kind = kind;
        positionList.add(new Position(3, -2));
        positionList.add(new Position(3, 0));
        positionList.add(new Position(0, 0));//center
        positionList.add(new Position(1, 0));
        positionList.add(new Position(2, 0));
        positionList.add(new Position(4, 0));
        positionList.add(new Position(5, 0));
        positionList.add(new Position(6, 0));
    }

    @Override
    public void changeFormation(Position position, BattleField<CartoonCharacter> battleField) {

        if (this.kind instanceof Justice) {
            FillFormation.fillFormation(new Justice(), this.formationMap, this.positionList);
        } else if (this.kind instanceof Evil) {
            FillFormation.fillFormation(new Evil(), this.formationMap, this.positionList);
        } else {
            assert false;
        }
        battleField.setBattleFieldLattice(formationMap, position);
    }
}

