package Character;

import Enums.Direction;
import Enums.Status;
import Frame.GameScreen;
import Frame.GameObject;
import Main.GameAdmin;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Character extends GameObject {
    protected GameAdmin admin;          //持有管理员的引用
    protected Direction direction;      //标记方向
    protected Direction preDirection;   //前一时刻方向
    protected Status status;            //标记当前状态
    protected boolean live;             //标记是否存活
    protected int moveSpeed;            //移动速度
    protected int atkTime;             //攻击动作完成时间(单位：毫秒)
    protected int xPre, yPre;         //记录上一时刻的位置
    protected Image currentImage;       //当前形象
    protected static Image hpImage, magicImage;     //血槽和魔法值槽
    static{
        try {
            hpImage = new Image(new FileInputStream(wd + "\\resources\\things\\hp.png"),60,5,false,false);
            magicImage = new Image(new FileInputStream(wd + "\\resources\\things\\magic.png"),60,5,false,false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Character(int x, int y, int width, int height,Direction direction,boolean good, GameAdmin admin){
        super(x,y,width,height,good);
        this.xPre = x;this.yPre = y;
        this.direction = direction;
        this.preDirection = direction;
        this.admin = admin;
        this.live = true;
    }

    public Direction getDirection() { return direction; }

    public void setDirection(Direction direction) { this.direction = direction; }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isLive() { return live; }

    protected abstract void move();
    protected abstract void stand();
    protected abstract void dead();
    protected abstract void stay();
}
