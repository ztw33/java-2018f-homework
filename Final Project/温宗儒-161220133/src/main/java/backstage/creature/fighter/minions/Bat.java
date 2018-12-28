package backstage.creature.fighter.minions;

import backstage.battleGround.Space;
import backstage.creature.battle.GourdBoys;
import backstage.creature.fighter.gourdboys.GourdBoy;
/**
 * @program: gourdBoys
 * @description: Object Bat
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class Bat extends Minion {
    private static Bat instance;
    public static Bat getInstance(int number){
        if(instance == null){
            synchronized (Bat.class) {
                if(instance == null) {
                    instance = new Bat(number);
                }
            }
        }
        return instance;
    }
    private Bat(int number){
        super(number);
        remoteAttack = true;
        name = "蝙蝠精";
        imageUrl = "/common/images/fighter/bat.png";
        attackUrl =  "/common/images/fighter/batAttack.jpg";
        attack = 12;
        hp = 23;
        defense = 30;
        setImageView();
    }

    public void attackGourdBoys(GourdBoys gourdBoys){
        GourdBoy top = gourdBoys.getTop();
        GourdBoy mid = gourdBoys.getMid();
        GourdBoy bottom = gourdBoys.getBottom();
        if (top != null && top.notDead()) {
            top.beAttacked(number * attack);
        } else if (mid != null && mid.notDead()) {
            mid.beAttacked(number * attack);
        } else if (bottom != null && bottom.notDead()) {
            bottom.beAttacked(number * attack);
        } else {
            Space.setWarEnd(true);
        }
    }

}
