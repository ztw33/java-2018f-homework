package common;

import battle.*;
import formation.*;
import gui.Controller;
import position.*;

import java.util.Random;

/**
 * @Description 创建正义阵营和邪恶阵营随机坐标，关键在于两者不能交叠
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CreateRandomPosition {

    public static JusticeAndEvilPosition createRandomPosition(Formation evilFormation, Formation justiceFormation)
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
                    rand.nextInt(Controller.FIELD_HEIGHT - (evilUpOffset + evilDownOffset)) + evilUpOffset,
                    rand.nextInt(Controller.FIELD_WIDTH - (evilLeftOffset + evilRightOffset)) + evilLeftOffset);

            newPosition.justicePosition = new Position(
                    rand.nextInt(Controller.FIELD_HEIGHT - (justiceUpOffset + justiceDownOffset)) + justiceUpOffset,
                    rand.nextInt(Controller.FIELD_WIDTH - (justiceLeftOffset + justiceRightOffset)) + justiceLeftOffset);
        }
        while ((Math.max(newPosition.justicePosition.getRow() - justiceUpOffset, newPosition.evilPosition.getRow() - evilUpOffset)
                <= Math.min(newPosition.justicePosition.getRow() + justiceDownOffset, newPosition.evilPosition.getRow() + evilDownOffset))
                && (Math.max(newPosition.justicePosition.getCol() - justiceLeftOffset, newPosition.evilPosition.getCol() - evilLeftOffset)
                <= Math.min(newPosition.justicePosition.getCol() + justiceRightOffset, newPosition.evilPosition.getCol() + evilRightOffset)));

        return newPosition;
    }
}
