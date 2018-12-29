package logic.creatureInformation.calabashBrother;/*
 * @author:Wu Gang
 * @create: 2018-11-21 18:49
 */

import logic.creatureInformation.CalabashBrother;
import logic.creatureInformation.enmu.CalabashBrotherEnum;

public class DaWa<T> extends CalabashBrother<T> {
    public DaWa() {
        super(CalabashBrotherEnum.first);
    }

    public DaWa(Class<T> tClass){
        super(CalabashBrotherEnum.first,tClass);
    }

    @Override
    public void releaseSkill() {

    }
}
