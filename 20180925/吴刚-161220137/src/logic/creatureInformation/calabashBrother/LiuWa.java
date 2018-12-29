package logic.creatureInformation.calabashBrother;/*
 * @author:Wu Gang
 * @create: 2018-11-21 18:54
 */

import logic.creatureInformation.CalabashBrother;
import logic.creatureInformation.enmu.CalabashBrotherEnum;

public class LiuWa<T> extends CalabashBrother<T> {
    public LiuWa(){
        super(CalabashBrotherEnum.sixth);
    }

    public LiuWa(Class<T> aClass) {
        super(CalabashBrotherEnum.sixth, aClass);
    }
    @Override
    public void releaseSkill() {

    }
}
