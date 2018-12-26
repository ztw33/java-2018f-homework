package logic.creatureInformation.calabashBrother;/*
 * @author:Wu Gang
 * @create: 2018-11-21 18:54
 */

import logic.creatureInformation.CalabashBrother;
import logic.creatureInformation.enmu.CalabashBrotherEnum;

public class WuWa<T> extends CalabashBrother<T> {
    public WuWa() {
        super(CalabashBrotherEnum.fifth);
    }

    public WuWa(Class<T> aClass) {
        super(CalabashBrotherEnum.fifth, aClass);
    }
    @Override
    public void releaseSkill() {

    }
}
