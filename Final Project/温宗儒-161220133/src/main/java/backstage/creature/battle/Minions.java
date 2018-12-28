package backstage.creature.battle;


import backstage.battleGround.Position;
import backstage.battleGround.Space;
import backstage.creature.fighter.minions.Bat;
import backstage.creature.fighter.minions.Centipede;
import backstage.creature.fighter.minions.Toad;


/**
 * @program: gourdBoys
 * @description: Object Minions
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class Minions implements Runnable{
    private Thread t;
    private Bat bat;
    private Centipede centipede;
    private Toad toad;

    public Minions(int batNumber, int centipedeNumber, int toadNumber){
        bat = Bat.getInstance(batNumber);
        centipede = Centipede.getInstance(centipedeNumber);
        toad = Toad.getInstance(toadNumber);
    }

    public void run(){
        try {
            while (!Space.isWarEnd()) {
                while (Space.isSoloEnd()) {
                    synchronized (GourdBoys.class) {
                        Thread.sleep(1000);
                        if (bat.getLocationY() > 20) {
                            Position[][] position = Space.getPosition();
                            bat.move(position, bat.getLocationX(), bat.getLocationY() - 4);
                            centipede.move(position, centipede.getLocationX(), centipede.getLocationY() - 4);
                            toad.move(position, toad.getLocationX(), toad.getLocationY() - 4);
                        }
                        if (bat.getNumber() > 0) {
                            bat.attackGourdBoys(Space.getGourdBoys());
                        } else {
                            bat.cleanImageView();
                        }
                        if (centipede.getNumber() > 0) {
                            centipede.attackGourdBoys(Space.getGourdBoys());
                        } else {
                            centipede.cleanImageView();
                        }
                        if (toad.getNumber() > 0) {
                            toad.attackGourdBoys(Space.getGourdBoys());
                        } else {
                            toad.cleanImageView();
                        }

                        if (bat.getNumber() <= 0 && centipede.getNumber() <= 0 && toad.getNumber() <= 0) {
                            Space.setWarEnd(true);
                            break;
                        }
                        bat.setImageBack();
                        ;
                        centipede.setImageBack();
                        toad.setImageBack();
                    }
                }
                Thread.sleep(100);
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        if(t == null){
            t = new Thread(this,"小喽啰们");
        }
        t.start();
    }



    public Bat getBat() { return bat; }

    public Centipede getCentipede() { return centipede; }

    public Toad getToad() { return toad; }
}
