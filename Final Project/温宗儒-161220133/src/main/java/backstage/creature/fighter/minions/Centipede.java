package backstage.creature.fighter.minions;

import backstage.battleGround.Space;
import backstage.creature.battle.GourdBoys;
import backstage.creature.fighter.gourdboys.GourdBoy;
/**
 * @program: gourdBoys
 * @description: Object Centipede
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class Centipede extends Minion {
    private static Centipede instance;
    public static Centipede getInstance(int number){
        if(instance == null){
            synchronized (Centipede.class) {
                if(instance == null) {
                    instance = new Centipede(number);
                }
            }
        }
        return instance;
    }


    private Centipede(int number){
        super(number);
        remoteAttack = false;
        name = "蜈蚣精";
        imageUrl = "/common/images/fighter/centipede.png";
        attackUrl =  "/common/images/fighter/centipedeAttack.jpg";
        attack = 11;
        hp = 33;
        defense = 40;
        setImageView();
    }

    public void attackGourdBoys(GourdBoys gourdBoys){
        GourdBoy top = gourdBoys.getTop();
        GourdBoy mid = gourdBoys.getMid();
        GourdBoy bottom = gourdBoys.getBottom();
        if(getLocationY()==20) {
            if (mid != null && mid.notDead()) {
                mid.beAttacked(number * attack);
            }else if (top != null && top.notDead()) {
                top.beAttacked(number * attack);
            }else if (bottom != null && bottom.notDead()) {
                bottom.beAttacked(number * attack);
            } else {
                Space.setWarEnd(true);
            }
        }
    }

}
