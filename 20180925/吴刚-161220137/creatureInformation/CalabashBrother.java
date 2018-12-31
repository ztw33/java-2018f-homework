package creatureInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:21
 */

//葫芦娃实体
public class CalabashBrother extends Creature{
    private CalabashBrotherEnum oneCalabashBrother;

    public CalabashBrother(CalabashBrotherEnum calabashBrother) {
        this.oneCalabashBrother = calabashBrother;
    }

    @Override
    public void sayName() {
        System.out.print(oneCalabashBrother.name);
    }
}