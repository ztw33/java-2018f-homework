package logic.creatureInformation.calabashBrother;/*
 * @author:Wu Gang
 * @create: 2018-11-21 18:52
 */

import logic.creatureInformation.CalabashBrother;
import logic.creatureInformation.enmu.CalabashBrotherEnum;

public class SanWa<T> extends CalabashBrother<T> {
    public SanWa() {
        super(CalabashBrotherEnum.third);
    }

    public SanWa(Class<T> aClass) {
        super(CalabashBrotherEnum.third, aClass);
    }
    @Override
    public void releaseSkill() {

    }
}
