package Character;

import Enums.Direction;
import Enums.Status;
import Frame.GameObject;
import javafx.scene.image.Image;

//游戏中所有人物的父类
public abstract class Character extends GameObject {
    protected GameAdmin admin;          //持有管理员的引用
    protected Direction direction;      //标记方向
    protected Direction preDirection;   //前一时刻方向
    protected Status status;            //标记当前状态
    protected boolean good;             //标记阵营
    protected boolean live;             //标记是否存活
    protected int moveSpeed;            //移动速度
    protected int atkTime;             //攻击动作完成时间(单位：毫秒)
    protected int xPre, yPre;         //记录上一时刻的位置
    protected Image currentImage;       //当前形象

    public Character(int x, int y, int width, int height,Direction direction,boolean good, GameAdmin admin){
        super(x,y,width,height);
        this.xPre = x;this.yPre = y;
        this.direction = direction;
        this.preDirection = direction;
        this.good = good;
        this.admin = admin;
        this.live = true;
    }
    public Direction getDirection() { return direction; }

    public void setDirection(Direction direction) { this.direction = direction; }

    public boolean isGood() { return good; }

    public void setGood(boolean good) { this.good = good; }

    public int getMoveSpeed() { return moveSpeed; }

    public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }

    public int getAtkTime() { return atkTime; }

    public void setAtkTime(int atkTime) { this.atkTime = atkTime; }

    public Direction getPreDirection() { return preDirection; }

    public void setPreDirection(Direction preDirection) { this.preDirection = preDirection; }

    public Image getCurrentImage() { return currentImage; }

    public void setCurrentImage(Image currentImage) { this.currentImage = currentImage; }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    protected abstract void move();
    protected abstract void stand();
    protected abstract void stay();

}
