package backstage.creature.fighter.minions;

import backstage.battleGround.Space;
import backstage.creature.battle.GourdBoys;
import backstage.creature.fighter.gourdboys.GourdBoy;
/**
 * @program: gourdBoys
 * @description: Object Toad
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class Toad extends Minion {
    private static Toad instance;
    public static Toad getInstance(int number){
        if(instance == null){
            synchronized (Toad.class) {
                if(instance == null) {
                    instance = new Toad(number);
                }
            }
        }
        return instance;
    }
    private Toad(int number){
        super(number);
        remoteAttack = false;
        name = "蛤蟆精";
        imageUrl = "/common/images/fighter/frog.png";
        attackUrl =  "/common/images/fighter/frogAttack.jpg";
        attack = 10;
        hp = 43;
        defense = 40;
        setImageView();
    }

    public void attackGourdBoys(GourdBoys gourdBoys){
        GourdBoy top = gourdBoys.getTop();
        GourdBoy mid = gourdBoys.getMid();
        GourdBoy bottom = gourdBoys.getBottom();
        if(getLocationY()==20) {
            if (bottom != null && bottom.notDead()) {
                bottom.beAttacked(number * attack);
            }else if (mid != null && mid.notDead()) {
                mid.beAttacked(number * attack);
            }else if (top != null && top.notDead()) {
                top.beAttacked(number * attack);
            } else {
                Space.setWarEnd(true);
            }
        }
    }
}
