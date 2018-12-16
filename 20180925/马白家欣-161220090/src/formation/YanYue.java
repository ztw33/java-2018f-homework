package formation;

import battle.BattleField;
import being.*;
import position.Position;

/**
 * @Description 偃月
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class YanYue <T extends CartoonCharacter> extends Formation<CartoonCharacter> {
    public YanYue(T kind) {
        super(4, 4, 4, 4);
        positionList.add(new Position(0, 0));//center
        positionList.add(new Position(0, 4));
        positionList.add(new Position(0, -2));
        positionList.add(new Position(0, -4));
        positionList.add(new Position(-1, 0));
        positionList.add(new Position(-1, -2));
        positionList.add(new Position(-1, -4));
        positionList.add(new Position(1, 0));
        positionList.add(new Position(1, -2));
        positionList.add(new Position(1, -4));
        positionList.add(new Position(-2, -1));
        positionList.add(new Position(-2, 1));
        positionList.add(new Position(2, -1));
        positionList.add(new Position(2, 1));
        positionList.add(new Position(-3, 0));
        positionList.add(new Position(-3, 2));
        positionList.add(new Position(3, 0));
        positionList.add(new Position(3, 2));
        positionList.add(new Position(-4, 3));
        positionList.add(new Position(4, 3));
        this.kind = kind;
    }

    @Override
    public void changeFormation(Position position, BattleField<CartoonCharacter> battleField) {

        assert this.kind instanceof Evil;
        FillFormation.fillFormation(new Evil(), this.formationMap, this.positionList);
        battleField.setBattleFieldLattice(formationMap, position);
    }
}

