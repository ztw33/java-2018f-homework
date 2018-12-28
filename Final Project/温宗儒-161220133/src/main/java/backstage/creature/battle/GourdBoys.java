package backstage.creature.battle;

import backstage.battleGround.Position;
import backstage.battleGround.Space;
import backstage.creature.fighter.gourdboys.GourdBoy;

/**
 * @program: gourdBoys
 * @description: Object GourdBoys which contains top, mid and bottom
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class GourdBoys implements Runnable {
    private Thread t;
    private GourdBoy top;
    private GourdBoy mid;
    private GourdBoy bottom;

    public void run(){
        try {
            while (!Space.isWarEnd()) {
                if (Space.isSoloEnd()) {
                    synchronized (Scorpion.class){
                    if (top.getLocationY() < 19) {
                        Position[][] position = Space.getPosition();
                        top.move(position, top.getLocationX(), top.getLocationY() + 4);
                        mid.move(position, mid.getLocationX(), mid.getLocationY() + 4);
                        bottom.move(position, bottom.getLocationX(), bottom.getLocationY() + 4);
                    }
                    if (top.notDead()) {
                        top.attackMinions(Space.getMinions());
                    } else {
                        top.cleanImageView();
                    }
                    if (mid.notDead()) {
                        mid.attackMinions(Space.getMinions());
                    } else {
                        mid.cleanImageView();
                    }
                    if (bottom.notDead()) {
                        bottom.attackMinions(Space.getMinions());
                    } else {
                        bottom.cleanImageView();
                    }

                    if (!top.notDead() && !mid.notDead() && !bottom.notDead()) {
                        Space.setWarEnd(true);
                        break;
                    }
                    Thread.sleep(1000);
                    top.setImageBack();
                    mid.setImageBack();
                    bottom.setImageBack();
                }
                }
                Thread.sleep(100);
            }

            Space.victory();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        if(t == null){
            t = new Thread(this,"葫芦娃们");
        }
        t.start();
    }

    public GourdBoy getTop() {
        return top;
    }

    public void setTop(GourdBoy top) {
        this.top = top;
    }

    public GourdBoy getMid() {
        return mid;
    }

    public void setMid(GourdBoy mid) {
        this.mid = mid;
    }

    public GourdBoy getBottom() {
        return bottom;
    }

    public void setBottom(GourdBoy bottom) {
        this.bottom = bottom;
    }

}
