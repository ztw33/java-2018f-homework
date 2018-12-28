package backstage.creature.battle;

import backstage.battleGround.Space;
import backstage.creature.fighter.Fighter;
/**
 * @program: gourdBoys
 * @description: Object Scorpion
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class Scorpion extends Fighter implements Runnable {
    private Thread t;
    public Scorpion(){
        name = "蝎子精";
        imageUrl = "/common/images/fighter/scorpion.png";
        attackUrl = "/common/images/fighter/scorpionAttack.jpg";
        setImageView();
        attack = 400;
        maxhp = 1700;
        hp =maxhp;
        defense = 70;
    }

    public void run(){
        try {
            while (notDead() && !Space.isSoloEnd()) {
                synchronized (FirstChild.class) {
                    attackFirstChild(Space.getFirstChild());
                    if (!Space.getFirstChild().notDead()) break;
                    setImageBack();
                    Thread.sleep(1000);
                }
            }
            if(notDead()) {
                for (int i = 0; i < 14; i++) {
                    move(Space.getPosition(), 15, 21 + i);
                    Thread.sleep(500);
                }
                Space.setSoloEnd(true);
            }else {
                cleanImageView();
                Space.setSoloEnd(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void attackFirstChild(FirstChild firstChild) throws InterruptedException {
        setAttackImageView();
        Thread.sleep(500);
        firstChild.beAttacked(attack);
    }

    public void start(){
        if(t == null){
            t = new Thread(this,name);
        }
        t.start();
    }

}
