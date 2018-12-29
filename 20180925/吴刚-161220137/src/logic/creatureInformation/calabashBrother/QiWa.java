package logic.creatureInformation.calabashBrother;/*
 * @author:Wu Gang
 * @create: 2018-11-21 18:55
 */

import logic.creatureInformation.CalabashBrother;
import logic.creatureInformation.enmu.CalabashBrotherEnum;

public class QiWa<T> extends CalabashBrother<T> {
    public QiWa() {
        super(CalabashBrotherEnum.seventh);
    }

    public QiWa(Class<T> aClass) {
        super(CalabashBrotherEnum.seventh, aClass);
    }
    @Override
    public void releaseSkill() {

    }
}
