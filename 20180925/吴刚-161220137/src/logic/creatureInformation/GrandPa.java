package logic.creatureInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:22
 */

//爷爷
public class GrandPa<T> extends Creature<T>{
    final String name = "爷爷";

    public GrandPa(){

    }

    public GrandPa(Class<T> imageClass) {
        super(imageClass);
    }

    @Override
    public void sayName() {
        System.out.print(name);
    }

    @Override
    public void releaseSkill() {

    }
}
