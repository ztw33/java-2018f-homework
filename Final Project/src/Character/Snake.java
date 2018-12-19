package Character;

import Enums.Direction;
import Enums.Status;
import Frame.GameObject;
import Thing.FireSphere;
import Thing.IceWave;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class Snake extends Character {
    private static Image[] standImages = null;
    private static Image[][] moveImages = null;
    private static Image[][] atkImages = null;
    private int [] moveCount = {0,0,0,0}, moveIndex = {0,0,0,0};
    private static int stepNumMin = 30, stepNumRange = 10;
    private int stepCount;
    private Random r = new Random();
    private int sizeX, sizeY;
    private double zoomRatio = 1.2;
    private int attackPossibility = 12;
    //初始化各种形象i
    static {
        try {
            standImages = new Image[]{
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\left.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\right.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\down.png")),
                    new Image(new FileInputStream(wd + "\\resources\\monster1\\stand\\up.png"))
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
    }

    @Override
    protected void move() {

        int dirIndex = 0;
        if(direction!=Direction.Stop) dirIndex = direction.ordinal();
        else stepCount--;
        //若方向发生改变, 则移动计数和形象都从0开始计
        if(direction != preDirection){
            moveCount[dirIndex] = 0;
            moveIndex[dirIndex] = 0;
        }
        //记录上一时刻位置
        this.xPre = this.getX(); this.yPre = this.getY();
        //根据当前方向设置坐标
        switch (direction){
            case Left: setX(getX()-moveSpeed);break;
            case Right:setX(getX()+moveSpeed);break;
            case Up:setY(getY()-moveSpeed);break;
            case Down:setY(getY()+moveSpeed);break;
            case Stop:break;
        }
        //控制人物不能出屏幕边界
        int screenWidth = (int)this.admin.getWidth();
        int screenHeight = (int)this.admin.getHeight();
        if(getX()<0) setX(0);
        else if(getX() > screenWidth-sizeX) setX(screenWidth-sizeX);
        if(getY()<0) setY(0);
        else if(getY() > screenHeight-sizeY) setY(screenHeight-sizeY);
        //修改人物形象, 并设置计数变量
        currentImage = moveImages[dirIndex][moveIndex[dirIndex]];
        moveCount[dirIndex]++;
        if(moveCount[dirIndex] >= sizeX/moveSpeed){
            moveCount[dirIndex] = 0;
            moveIndex[dirIndex]++;
            if(moveIndex[dirIndex] >= moveImages[dirIndex].length)
                moveIndex[dirIndex] = 0;
        }
        //设置preDirection
        preDirection = direction;
        if(!good){
            if(stepCount <= 0){
                this.direction = randomDirection();     //随机改变方向
                stepCount = r.nextInt(stepNumRange)+stepNumMin;
            } else{
                stepCount--;
            }
        }
        if(direction!=Direction.Stop && r.nextInt(100)<attackPossibility)
            attack();
    }

    @Override
    protected void stand() {
        currentImage = standImages[direction.ordinal()];
    }

    @Override
    protected void stay(){
        setX(xPre); setY(yPre);
    }
    @Override
    public void draw(GraphicsContext gc) {
        sizeX = (int)(currentImage.getWidth()*zoomRatio);
        sizeY = (int)(currentImage.getHeight()*zoomRatio);
        if(live){
            gc.drawImage(currentImage,getX(),getY(),sizeX,sizeY);
        }

        move();
        collidesWithObjects(this.admin.getObjectList());
    }

    @Override
    public void update() {

    }
    //获取一个随机方向
    Direction randomDirection(){
        Direction[] dirs = Direction.values();
        return dirs[r.nextInt(dirs.length)];
    }

    public Rectangle getRect(){
        return new Rectangle(getX(),getY(),sizeX,sizeY);
    }

    //分情况讨论各种碰撞
    private boolean collidesWithObjects(List<GameObject> objects){
        for(int i=0;i<objects.size();i++){
            GameObject o = objects.get(i);
            if(o!=this){
                if(o instanceof FemaleFighter && ((FemaleFighter) o).getRect().intersects(this.getRect())){
                    this.stay();((FemaleFighter) o).stay();
                    return true;
                }
                if(o instanceof IceWave && ((IceWave) o).getRect().intersects(this.getRect())){
                    this.hitByWave((IceWave)o);
                }
            }
        }
        return false;
    }

    public void attack(){
        switch (direction){
            case Left:{
                FireSphere left = new FireSphere(getX()-sizeX/2,getY(),direction,this.admin);
                admin.addObject(left);
                break;
            }
            case Right:{
                FireSphere right = new FireSphere(getX()+sizeX,getY(),direction,this.admin);
                admin.addObject(right);
                break;
            }
            case Up:{
                FireSphere up = new FireSphere(getX(),getY()-sizeY/2,direction,this.admin);
                admin.addObject(up);
                break;
            }
            case Down:{
                FireSphere down = new FireSphere(getX(),getY()+sizeY,direction,this.admin);
                admin.addObject(down);
                break;
            }
        }
    }
    private void hitByWave(IceWave wave){
        this.admin.removeObject(wave);
        this.admin.removeObject(this);
    }

}
