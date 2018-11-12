package creatureInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:22
 */

//怪兽实体
public class Monster extends Creature{
    private MonsterEnum oneMonster;

    public Monster(MonsterEnum oneMonster) {
        this.oneMonster = oneMonster;
    }

    @Override
    public void sayName() {
        System.out.print(oneMonster.name);
    }
}