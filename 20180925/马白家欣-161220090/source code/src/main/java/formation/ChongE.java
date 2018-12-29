package formation;

import battle.BattleField;
import being.*;
import position.Position;

/**
 * @Description 冲轭
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class ChongE <T extends CartoonCharacter> extends Formation<CartoonCharacter> {
    public ChongE(T kind) {
        super(2, 3, 1, 2);
        this.kind = kind;
        positionList.add(new Position(0, 0));//center
        positionList.add(new Position(0, 2));
        positionList.add(new Position(-2, 0));
        positionList.add(new Position(-1, -1));
        positionList.add(new Position(1, -1));
        positionList.add(new Position(2, 0));
        positionList.add(new Position(3, -1));
    }

    @Override
    public void changeFormation(Position position, BattleField<CartoonCharacter> battleField) {

        assert this.kind instanceof Evil;
        FillFormation.fillFormation(new Evil(), this.formationMap, this.positionList);
        battleField.setBattleFieldLattice(formationMap, position);
    }
}

