package logic.creatureInformation.calabashBrother;/*
 * @author:Wu Gang
 * @create: 2018-11-21 18:52
 */

import logic.creatureInformation.CalabashBrother;
import logic.creatureInformation.enmu.CalabashBrotherEnum;

public class ErWa<T> extends CalabashBrother<T> {
    public ErWa() {
        super(CalabashBrotherEnum.second);
    }

    public ErWa(Class<T> aClass) {
        super(CalabashBrotherEnum.second, aClass);
    }

    @Override
    public void releaseSkill() {

    }
}
