package logic.creatureInformation.monster;/*
 * @author:Wu Gang
 * @create: 2018-11-21 19:14
 */

import logic.creatureInformation.Monster;
import logic.creatureInformation.enmu.MonsterEnum;

public class Scorpion<T> extends Monster<T> {
    public Scorpion() {
        super(MonsterEnum.scorpion);
    }

    public Scorpion(Class<T> imageClass) {
        super(imageClass, MonsterEnum.scorpion);
    }

    @Override
    public void releaseSkill() {

    }
}
