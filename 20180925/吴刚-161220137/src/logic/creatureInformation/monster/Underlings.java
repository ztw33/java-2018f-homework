package logic.creatureInformation.monster;/*
 * @author:Wu Gang
 * @create: 2018-11-21 19:18
 */

import logic.creatureInformation.Monster;
import logic.creatureInformation.enmu.MonsterEnum;

public class Underlings<T> extends Monster<T> {
    public Underlings() {
        super(MonsterEnum.underlings);
    }

    public Underlings(Class<T> imageClass) {
        super(imageClass, MonsterEnum.underlings);
    }

    @Override
    public void releaseSkill() {

    }
}
