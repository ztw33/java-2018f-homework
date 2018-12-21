package Character;

import Enums.Direction;
import Enums.Status;
import Frame.GameObject;
import Main.GameAdmin;
import Thing.BloodMedicine;
import Thing.FireSphere;
import Thing.IceHit;
import Thing.Shield;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Snake extends Character {
    private static Image[] standImages = null;
    private static Image[] deadImages = null;
    private static Image[][] moveImages = null;
    private static Image[][] atkImages = null;
    private int [] moveCount = {0,0,0,0}, moveIndex = {0,0,0,0};
    private static int stepNumMin = 30, stepNumRange = 10;
    private static int deadDisappearTime = 3000;
    private int stepCount;
    private Random r = new Random();
    private int sizeX, sizeY;
    private double zoomRatio = 1.2;
    private int attackPossibility = 12;
    private int hp;
    private int probabilityGenerateBlood = 40;           //掉落药品的概率
    //初始化各种形象
    static {
        try {
            standImages = new Image[]{
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\left.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\right.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\down.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\up.png"))
            };
            deadImages = new Image[]{
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\dead\\deadLeft.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\dead\\deadRight.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\dead\\deadUp.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\dead\\deadDown.png"))
            };
            moveImages = new Image[][]{
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveLeft1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveLeft2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveLeft3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveLeft4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveLeft5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveLeft6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveRight1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveRight2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveRight3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveRight4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveRight5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveRight6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveUp1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveUp2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveUp3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveUp4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveUp5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveUp6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveDown1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveDown2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveDown3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveDown4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveDown5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\move\\moveDown6.png"))
                    }
            };
            atkImages = new Image[][]{
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkLeft1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkLeft2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkLeft3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkLeft4.png")),
                            standImages[Direction.Left.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkRight1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkRight2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkRight3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkRight4.png")),
                            standImages[Direction.Right.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkUp1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkUp2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkUp3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkUp4.png")),
                            standImages[Direction.Up.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkDown1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkDown2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkDown3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\monster1\\atk\\atkDown4.png")),
                            standImages[Direction.Down.ordinal()]
                    }
            };

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Snake(int x, int y, int width, int height, Direction direction, boolean good, GameAdmin admin) {
        super(x, y, width, height, direction, good, admin);
        moveSpeed = 4;
        atkTime = 500;
        status = Status.Standing;
        currentImage = standImages[direction.ordinal()];
        stepCount = r.nextInt(stepNumRange)+stepNumMin;
        hp = 100;
    }


    @Override
    protected void move() {
        int dirIndex = 0;
        if(direction!=Direction.Stop) dirIndex = direction.ordinal();
        else stepCount--;
        //方向发生改变
        if(direction != preDirection){
            moveCount[dirIndex] = 0;
            moveIndex[dirIndex] = 0;
            preDirection = direction;       
        }
        //记录上一时刻位置
        if(xPre != getX() || yPre != getY()){
            xPre = getX(); yPre = getY();
        }

        switch (direction){
            case Left: setX(getX()-moveSpeed);break;
            case Right:setX(getX()+moveSpeed);break;
            case Up:setY(getY()-moveSpeed);break;
            case Down:setY(getY()+moveSpeed);break;
            case Stop:break;
        }

        int screenWidth = (int)this.admin.getWidth();
        int screenHeight = (int)this.admin.getHeight();
        if(getX()<0) setX(0);
        else if(getX() > screenWidth-sizeX) setX(screenWidth-sizeX);
        if(getY()<0) setY(0);
        else if(getY() > screenHeight-sizeY) setY(screenHeight-sizeY);

        currentImage = moveImages[dirIndex][moveIndex[dirIndex]];
        moveCount[dirIndex]++;
        if(moveCount[dirIndex] >= sizeX/moveSpeed){
            moveCount[dirIndex] = 0;
            moveIndex[dirIndex]++;
            if(moveIndex[dirIndex] >= moveImages[dirIndex].length)
                moveIndex[dirIndex] = 0;
        }

        if(stepCount <= 0){
            this.direction = randomDirection();     //随机改变方向
            stepCount = r.nextInt(stepNumRange)+stepNumMin;
        } else{
            stepCount--;
        }

        if(direction!=Direction.Stop && r.nextInt(100)<attackPossibility)
            attack();
    }

    @Override
    protected void stand() {
        currentImage = standImages[direction.ordinal()];
    }

    private void disappear(){

        if(r.nextInt(100)<probabilityGenerateBlood){        //一定概率掉落物品
            this.admin.addObject(new BloodMedicine(getX(),getY(),true,this.admin));
        }
        this.admin.removeObject(this);
    }

    @Override
    protected void dead(){
        status = Status.Dead;
        live = false;
        if(direction == Direction.Stop)
            currentImage = deadImages[r.nextInt(deadImages.length)];
        else
            currentImage = deadImages[direction.ordinal()];
        //死亡一定时间后消失
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                disappear();
                System.gc();cancel();
            }
        },deadDisappearTime);
        this.admin.showInfo("你击杀了一只蛇怪！");
        this.admin.setNumMonster(admin.getNumMonster()-1);      //怪物数量-1
    }

    @Override
    protected void stay() {
        setX(xPre); setY(yPre);
    }

    //获取一个随机方向
    Direction randomDirection(){
        Direction[] dirs = Direction.values();
        return dirs[r.nextInt(dirs.length)];
    }

    public Rectangle getRect(){
        return new Rectangle(getX(),getY(),sizeX,sizeY);
    }

    private boolean collidesWithObjects(List<GameObject> objects){
        for(int i=0;i<objects.size();i++){
            GameObject o = objects.get(i);
            if(o!=this){
                if(o instanceof Fighter && ((Fighter) o).getRect().intersects(this.getRect())){
                    this.stay();((Fighter) o).stay();
                    return true;
                }
                if(o instanceof Snake && ((Snake) o).getRect().intersects(this.getRect())){
                    ((Snake) o).stay();this.stay();
                }
                if(o instanceof Shield && ((Shield) o).getRect().intersects(this.getRect())){
                    this.stay();
                }
            }
        }
        return false;
    }

    public void attack(){
        switch (direction){
            case Left:{
                FireSphere left = new FireSphere(getX()-sizeX/2,getY(),direction,false,this.admin);
                admin.addObject(left);
                break;
            }
            case Right:{
                FireSphere right = new FireSphere(getX()+sizeX,getY(),direction,false,this.admin);
                admin.addObject(right);
                break;
            }
            case Up:{
                FireSphere up = new FireSphere(getX(),getY()-sizeY/2,direction,false,this.admin);
                admin.addObject(up);
                break;
            }
            case Down:{
                FireSphere down = new FireSphere(getX(),getY()+sizeY,direction,false,this.admin);
                admin.addObject(down);
                break;
            }
        }
    }
    //蛇被击中
    public void hitByWave(int hitPower){
        this.admin.addObject(new IceHit(getX(),getY(),true,this.admin));
        hp -= hitPower;
        if(hp <= 0) {

            dead();
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        sizeX = (int)(currentImage.getWidth()*zoomRatio);
        sizeY = (int)(currentImage.getHeight()*zoomRatio);
        gc.drawImage(currentImage,getX(),getY(),sizeX,sizeY);

        if(hp>=0){
            gc.drawImage(hpImage,getX(),getY()-5,(double)hp/100.0*hpImage.getWidth(),hpImage.getHeight());
        }
        if(live){
            move();
            collidesWithObjects(this.admin.getObjectList());
        }

    }

    public void update() {

    }
}
