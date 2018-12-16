package formation;

import battle.BattleField;
import being.*;
import position.Position;

/**
 * @Description 鹤翼
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class HeYi <T extends CartoonCharacter> extends Formation<CartoonCharacter> {
    public HeYi(T kind) {
        super(3, 0, 3, 4);
        positionList.add(new Position(0, 0));//center
        positionList.add(new Position(0, 4));
        positionList.add(new Position(-1, -1));
        positionList.add(new Position(-1, 1));
        positionList.add(new Position(-2, -2));
        positionList.add(new Position(-2, 2));
        positionList.add(new Position(-3, -3));
        positionList.add(new Position(-3, 3));
        this.kind = kind;
    }

    @Override
    public void changeFormation(Position position, BattleField<CartoonCharacter> battleField) {

        assert this.kind instanceof Evil;
        FillFormation.fillFormation(new Evil(), this.formationMap, this.positionList);
        battleField.setBattleFieldLattice(formationMap, position);
    }
}

