package formation;

import battle.BattleField;
import being.*;
import position.Position;

/**
 * @Description 锋矢
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class FengShi <T extends CartoonCharacter> extends Formation<CartoonCharacter> {
    public FengShi(T kind) {
        super(0, 5, 3, 4);
        positionList.add(new Position(0, 0));//center
        positionList.add(new Position(0, 4));
        positionList.add(new Position(1, 0));
        positionList.add(new Position(1, -1));
        positionList.add(new Position(1, 1));
        positionList.add(new Position(2, 0));
        positionList.add(new Position(2, -2));
        positionList.add(new Position(2, 2));
        positionList.add(new Position(3, 0));
        positionList.add(new Position(3, -3));
        positionList.add(new Position(3, 3));
        positionList.add(new Position(4, 0));
        positionList.add(new Position(5, 0));
        this.kind = kind;
    }

    @Override
    public void changeFormation(Position position, BattleField<CartoonCharacter> battleField) {

        assert this.kind instanceof Evil;
        FillFormation.fillFormation(new Evil(), this.formationMap, this.positionList);
        battleField.setBattleFieldLattice(formationMap, position);
    }
}

