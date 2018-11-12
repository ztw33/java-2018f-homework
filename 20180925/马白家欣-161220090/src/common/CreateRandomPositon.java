package com.homework3.common;

import com.homework3.battle.BattleField;
import com.homework3.coordinate.JusticeAndEvilPosition;
import com.homework3.coordinate.Position;
import com.homework3.formation.Formation;

import java.util.Random;

/**
 * @Description 创建正义阵营和邪恶阵营随机坐标，关键在于两者不能交叠
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class CreateRandomPositon {

    public static JusticeAndEvilPosition createRandomPositon(Formation evilFormation, Formation justiceFormation)
    {
        Random rand = new Random();
        int evilUpOffset = evilFormation.getUpOffset();
        int evilDownOffset = evilFormation.getDownOffset();
        int evilLeftOffset = evilFormation.getLeftOffset();
        int evilRightOffset = evilFormation.getRightOffset();

        int justiceUpOffset = justiceFormation.getUpOffset();
        int justiceDownOffset = justiceFormation.getDownOffset();
        int justiceLeftOffset = justiceFormation.getLeftOffset();
        int justiceRightOffset = justiceFormation.getRightOffset();

        JusticeAndEvilPosition newPosition = new JusticeAndEvilPosition();

        do {
            newPosition.evilPosition = new Position(
                    rand.nextInt(BattleField.FIELD_SIZE - (evilUpOffset + evilDownOffset)) + evilUpOffset,
                    rand.nextInt(BattleField.FIELD_SIZE - (evilLeftOffset + evilRightOffset)) + evilLeftOffset);

            newPosition.justicePosition = new Position(
                    rand.nextInt(BattleField.FIELD_SIZE - (justiceUpOffset + justiceDownOffset)) + justiceUpOffset,
                    rand.nextInt(BattleField.FIELD_SIZE - (justiceLeftOffset + justiceRightOffset)) + justiceLeftOffset);
        }
        while ((Math.max(newPosition.justicePosition.getRow() - justiceUpOffset, newPosition.evilPosition.getRow() - evilUpOffset)
                <= Math.min(newPosition.justicePosition.getRow() + justiceDownOffset, newPosition.evilPosition.getRow() + evilDownOffset))
                && (Math.max(newPosition.justicePosition.getCol() - justiceLeftOffset, newPosition.evilPosition.getCol() - evilLeftOffset)
                <= Math.min(newPosition.justicePosition.getCol() + justiceRightOffset, newPosition.evilPosition.getCol() + evilRightOffset)));

        return newPosition;
    }


}
