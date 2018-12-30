package logic.creatureInformation.monster;/*
 * @author:Wu Gang
 * @create: 2018-11-21 19:17
 */

import logic.creatureInformation.Monster;
import logic.creatureInformation.enmu.MonsterEnum;

public class Snake<T> extends Monster<T> {
    public Snake() {
        super(MonsterEnum.snake);
    }

    public Snake(Class<T> imageClass) {
        super(imageClass, MonsterEnum.snake);
    }

    @Override
    public void releaseSkill() {

    }
}
