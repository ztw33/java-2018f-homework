package logic.creatureInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:21
 */

import logic.creatureInformation.enmu.CalabashBrotherEnum;

//葫芦娃实体
public abstract class CalabashBrother<T> extends Creature<T>{
    private CalabashBrotherEnum oneCalabashBrother;

    public CalabashBrother(CalabashBrotherEnum calabashBrother) {
        this.oneCalabashBrother = calabashBrother;
    }

    public CalabashBrother(CalabashBrotherEnum calabashBrother, Class<T> tClass){
        super(tClass);
        this.oneCalabashBrother = calabashBrother;
    }

    @Override
    public void sayName() {
        System.out.print(oneCalabashBrother.name);
    }
}