package calabashBrothers;

import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：空间上的格点，映射到BattleField的容器
 */
public class unit {
    private int x;
    private int y;
    private Creature creature;

    public unit(int x, int y) {
        this.x = x;
        this.y = y;
        this.creature = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        if(this.creature==null){
            this.creature = creature;
        }else{
            System.out.println("冲突了");
        }
    }

    public boolean none(){
        return this.creature==null;
    }

    public void removeCreature(){
        this.creature = null;
    }

    public void showCreature(){
        this.creature.selfIntroduction();
    }

}
