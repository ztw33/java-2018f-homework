package logic.creatureInformation.calabashBrother;/*
 * @author:Wu Gang
 * @create: 2018-11-21 18:53
 */

import logic.creatureInformation.CalabashBrother;
import logic.creatureInformation.enmu.CalabashBrotherEnum;

public class SiWa<T> extends CalabashBrother<T> {
    public SiWa() {
        super(CalabashBrotherEnum.fourth);
    }

    public SiWa(Class<T> aClass) {
        super(CalabashBrotherEnum.fourth, aClass);
    }
    @Override
    public void releaseSkill() {

    }
}
