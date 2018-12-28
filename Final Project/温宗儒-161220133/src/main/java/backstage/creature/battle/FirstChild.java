package backstage.creature.battle;
import backstage.battleGround.Space;
import backstage.creature.fighter.gourdboys.Attribute;
import backstage.creature.fighter.Fighter;

/**
 * @program: gourdBoys
 * @description: Object FirstChild
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class FirstChild extends Fighter implements Runnable{
    private Thread t;
    public FirstChild(){
        remoteAttack = false;
        name = Attribute.FIRST.getName();
        attack = Attribute.FIRST.getAttack();
        maxhp = Attribute.FIRST.getMaxhp();
        hp = maxhp;
        defense = Attribute.FIRST.getDefense();
        imageUrl = "/common/images/fighter/gourdboys/firstChild.png";
        attackUrl = "/common/images/fighter/gourdboys/firstChildAttack.jpg";
        setImageView();
    }

    private void attackScorpion(Scorpion scorpion) throws InterruptedException {
        setAttackImageView();
        Thread.sleep(500);
        scorpion.beAttacked(attack);
    }

    public void run(){
        try {
            while (notDead() && !Space.isSoloEnd()) {
                synchronized (Scorpion.class) {
                    Thread.sleep(1000);
                    attackScorpion(Space.getScorpion());
                    if (!Space.getScorpion().notDead()) break;
                    setImageBack();
                }
            }
            if(notDead()) {
                for (int i = 0; i < 14; i++) {
                    move(Space.getPosition(), 15, 18 - i);
                    Thread.sleep(500);
                }
                Space.setSoloEnd(true);
            }else {
                cleanImageView();
                Space.setSoloEnd(true);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        if(t == null){
            t = new Thread(this,name);
        }
        t.start();
    }


}
