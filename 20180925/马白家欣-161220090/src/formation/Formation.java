package formation;

import battle.BattleField;
import being.*;
import position.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 阵型，向下重载changeFormation方法后可以实现各种阵型的打印，直接调用Formation的hangeFormation会AssertException
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

abstract public class Formation <T extends Being> {

    private int upOffset;
    private int downOffset;
    private int leftOffset;
    private int rightOffset;

    protected Map<Position, T> formationMap = new HashMap<>();
    protected List<Position> positionList = new ArrayList<>();
    protected T kind;

    Formation(int upOffset, int downOffset, int leftOffset, int rightOffset) {
        this.upOffset = upOffset;
        this.downOffset = downOffset;
        this.leftOffset = leftOffset;
        this.rightOffset = rightOffset;
    }

    public void changeFormation(Position position, BattleField<CartoonCharacter> battleField) {

        /**
         * @Description 传入BattleField对象后可以利用它的public方法修改BattleFieldLatticeArray，
         *               此函数待override，为了安全，如果直接调用将AssertException
         * @Author LUCUS BAI
         * @Date 2018/10/24
         * @Parameters [position, battleField, cartoonCharacter]
         * @ReturnValue void
         */
        //WAITING FOR OVERRIDE
        assert false;
    }

    public int getUpOffset() {
        return upOffset;
    }

    public int getDownOffset() {
        return downOffset;
    }

    public int getLeftOffset() {
        return leftOffset;
    }

    public int getRightOffset() {
        return rightOffset;
    }

}
