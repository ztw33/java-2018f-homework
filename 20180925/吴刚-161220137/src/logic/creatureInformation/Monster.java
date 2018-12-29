package logic.creatureInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:22
 */

import logic.creatureInformation.enmu.MonsterEnum;

//怪兽实体
public abstract class Monster<T> extends Creature<T>{
    private MonsterEnum oneMonster;

    public Monster(MonsterEnum oneMonster) {
        this.oneMonster = oneMonster;
    }

    public Monster(Class<T> imageClass, MonsterEnum oneMonster) {
        super(imageClass);
        this.oneMonster = oneMonster;
    }

    @Override
    public void sayName() {
        System.out.print(oneMonster.name);
    }

    @Override
    public void releaseSkill(){
        assert false;
    }
}