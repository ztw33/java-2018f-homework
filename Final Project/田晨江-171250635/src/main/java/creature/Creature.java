package creature;
import formation.ConflictException;
import javafx.scene.image.Image;
import world.BattleField;

import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public abstract class Creature implements Comparable, Runnable {

    protected String name;
    private Creature creature;
    private Location location;
    private Image image;
    private Random random;
    private Status status = Status.LIVE;
    private boolean isGoodCreature = false;

    private BattleField battleField;

    /**基本方法*/
    public String toString(){return name;}

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        location.setLocation_creature(this);
    }

    public void setCreature(Creature creature){
        this.creature = creature;
    }

    public boolean compareTo(Comparable another) {
        return false;
    }

    public Image getImage() {
        if(this.status == Status.DEAD) return new Image("pic/" + "die.png");
        return image;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }


    /*获得两个生物的距离*/
    public int distanceTo (Creature anotherCreature) {
        Location another = anotherCreature.getLocation();
        return Math.abs(another.getX() - this.location.getX()) + Math.abs(another.getY() - this.location.getY());
    }


    /* 模版方法 */
    public final void run(){
        System.out.println(this.toString() + "线程启动");
        try{
            while(true){
//                System.out.println(battleField);
//                synchronized (creature) {
                    switch (this.status){
                        case LIVE:  move(); break;
                        case FIGHTING: fight(); break;
                        case DEAD: dead(); break;
                        default: ;
                    }
//                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e){
            System.out.println(this.toString() + "线程切断:"+this.status);
        }
    }


    /**作战方法*/
    protected void move()  {
//        System.out.println(this + "移动");
        switch (new Random().nextInt(5)){
            case 0:
                //静止
                break;
            case 1:
                this.moveAStep(Direction.LEFT);
                break;
            case 2:
                this.moveAStep(Direction.RIGHT);
                break;
            case 3:
                this.moveAStep(Direction.UP);
                break;
            case 4:
                this.moveAStep(Direction.DOWN);
                break;
            default: ;
        }
    }

    private final int step = 1;
    protected final void moveAStep(Direction d)  {
        int offset_x = 0, offset_y = 0;
        int x = this.location.getX();
        int y = this.location.getY();
        switch (d) {
            case LEFT:
                offset_x -= step;
                break;
            case RIGHT:
                offset_x += step;
                break;
            case UP:
                offset_y -= step;
                break;
            case DOWN:
                offset_y += step;
                break;
            default:

        }
        this.getLocation().setEmpty(true);
        Creature temp = this;
        //设为空地

        this.battleField.addCreature(new Space(), this.location);
        this.location.setLocation_creature(new Space());

        Location newLocation = new Location(x + offset_x,y + offset_y);
//        if(x + offset_x > battleField.getRow() || y + offset_y > battleField.getColumn()){
//            return;
//        }
        this.setLocation(newLocation);
        newLocation.setEmpty(false);
        battleField.addCreature(temp, newLocation);
    }



    private void setFight(boolean alive) {
        if(alive) {
            status = Status.LIVE;
        } else {
            status = Status.FIGHTING;
            new java.util.Timer().schedule(new TimerTask() {
                @Override
                public void run() { //500毫秒后变为死亡状态
                    status = Status.DEAD;
                }
            }, 500);
        }
    }


    protected void fight(){
        System.out.println(this.name + "战斗中");
    }

    protected void dead(){

    }


    public synchronized void checkForward(){
        boolean flag = this.isGoodCreature;
        for(Creature ct : battleField.getAllCreature())
            if(ct!=this && ct.getStatus()==Status.LIVE && this.distanceTo(ct) < 3) {
                if(flag == (ct.isGoodCreature)) {
                    this.move(); //进行移动 并避免相撞
                } else {
                    boolean alive = new Random().nextBoolean();
                    ct.setFight(alive);
                    this.setFight(!alive);
                }
            }
    }



    /**
     * 枚举类
     */
    public enum Status {
        LIVE, FIGHTING, DEAD
    }

    enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    protected enum CheckStatus{
        NORMAL, FRIEND, ENEMY
    }


/*
     打印当前名字+位置
    public void printCreature(){
        System.out.print(name+":  (" +x+","+y+")");
    }
*/


}




