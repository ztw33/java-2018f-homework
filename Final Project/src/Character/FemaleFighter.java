package Character;

import Animation.RoleAnimation;
import Enums.Direction;
import Enums.Status;

import Frame.GameObject;

import Thing.IceWave;
import Thing.Weapon;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

//女战士类
//TODO:
//设置两次攻击之间的时间间隔
//添加怪物受击效果
//设置我方被击中的逻辑
//存档和读取功能(序列化)
public class FemaleFighter extends Character{

    private int [] moveCount = {0,0,0,0}, moveIndex = {0,0,0,0};
    private double transformPara;   //移动时图片切换速度的参数, 越大则图片切换越快
    private double zoomRatio = 1.0;
    private int sizeX, sizeY;

    private boolean isArmed;        //标记是否佩戴武器
    private Weapon weapon;

    private static Image[] standImages = null;
    private static Image[][] moveImages = null;
    private static Image[][] atkImages = null;

    static{

        try {

            standImages = new Image[]{
                    new Image(new FileInputStream(wd + "\\resources\\role1\\stand\\left.png")),
                    new Image(new FileInputStream(wd + "\\resources\\role1\\stand\\right.png")),
                    new Image(new FileInputStream(wd + "\\resources\\role1\\stand\\up.png")),
                    new Image(new FileInputStream(wd + "\\resources\\role1\\stand\\down.png"))
            };
            moveImages = new Image[][]{
                    {
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveLeft1.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveLeft2.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveLeft3.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveLeft4.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveLeft5.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveLeft6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveRight1.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveRight2.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveRight3.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveRight4.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveRight5.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveRight6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveUp1.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveUp2.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveUp3.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveUp4.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveUp5.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveUp6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveDown1.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveDown2.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveDown3.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveDown4.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveDown5.png")),
                            new Image(new FileInputStream(wd+"\\resources\\role1\\move\\moveDown6.png"))
                    }
            };
            atkImages = new Image[][]{
                    {
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkLeft2.png")),
                            standImages[Direction.Left.ordinal()]   //ordinal返回枚举量的序数
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkRight2.png")),
                            standImages[Direction.Right.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkUp2.png")),
                            standImages[Direction.Up.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\role1\\atk\\atkDown2.png")),
                            standImages[Direction.Down.ordinal()]
                    }
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FemaleFighter(int x, int y, int width, int height, Direction direction, boolean good, GameAdmin admin) {
        super(x, y, width, height, direction, good, admin);
        stand();
        moveSpeed = 15;
        atkTime = 80;
        transformPara = 2;
        status = Status.Standing;
        currentImage = standImages[direction.ordinal()];
        isArmed = false;

    }

    @Override
    protected void move() {
        int dirIndex = direction.ordinal();
        if(direction == Direction.Left || direction == Direction.Right) transformPara = 3;
        else transformPara = 2;
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
        if(isArmed && weapon!=null)
            weapon.move(direction,moveSpeed,moveIndex[dirIndex]);
        //控制人物不能出屏幕边界
        int sizeX = getWidth(), sizeY = getHeight();
        int screenWidth = (int)this.admin.getWidth();
        int screenHeight = (int)this.admin.getHeight();
        if(getX()<0) setX(0);
        else if(getX() > screenWidth-sizeX) setX(screenWidth-sizeX);
        if(getY()<0) setY(0);
        else if(getY() > screenHeight-sizeY) setY(screenHeight-sizeY);
        //修改人物形象, 并设置计数变量
        currentImage = moveImages[dirIndex][moveIndex[dirIndex]];
        moveCount[dirIndex]++;
        if(moveCount[dirIndex] >= currentImage.getWidth()/transformPara/moveSpeed){
            moveCount[dirIndex] = 0;
            moveIndex[dirIndex]++;
            if(moveIndex[dirIndex] >= moveImages[dirIndex].length)
                moveIndex[dirIndex] = 0;
        }
        //设置preDirection
        preDirection = direction;
    }

    @Override
    protected void stand() {
        currentImage = standImages[direction.ordinal()];
        if(isArmed)
            weapon.stand();
    }

    @Override
    public void stay(){
        status = Status.Standing;
        setX(xPre);setY(yPre);
    }
    @Override
    public void draw(GraphicsContext gc) {
        sizeX = (int)(currentImage.getWidth()*zoomRatio);
        sizeY = (int)(currentImage.getHeight()*zoomRatio);
        if(this.live){
            //将当前形象画到屏幕上
            gc.drawImage(currentImage,getX(),getY(),sizeX,sizeY);
        }
        //根据状态执行动作
        switch (status){
            case Moving: move();break;
            case Standing:stand();break;
            case Attacking:attack();break;
            default:break;
        }
        //碰撞处理函数
        collidesWithObjects(this.admin.getObjectList());
    }

    @Override
    public void update() {

    }

    public void attack(){
        if(!isArmed) return;        //只有戴上武器之后才能攻击
        switch (direction){
            case Left: {
                IceWave left = new IceWave(getX()-sizeX,getY(),direction,this.admin);
                new RoleAnimation(this.admin.getGraphicsContext2D(),getX(),getY(),atkTime,atkImages[direction.ordinal()]).run();
                this.admin.addObject(left);
                break;
            }
            case Right:{
                IceWave right = new IceWave(getX()+sizeX,getY(),direction,this.admin);
                new RoleAnimation(this.admin.getGraphicsContext2D(),getX(),getY(),atkTime,atkImages[direction.ordinal()]).run();
                this.admin.addObject(right);
                break;
            }
            case Up:{
                IceWave up = new IceWave(getX(),getY()-sizeX,direction,this.admin);
                new RoleAnimation(this.admin.getGraphicsContext2D(),getX(),getY(),atkTime,atkImages[direction.ordinal()]).run();
                this.admin.addObject(up);
                break;
            }
            case Down:{
                IceWave down = new IceWave(getX(),getY()+sizeY,direction,this.admin);
                new RoleAnimation(this.admin.getGraphicsContext2D(),getX(),getY(),atkTime,atkImages[direction.ordinal()]).run();
                this.admin.addObject(down);
                break;
            }
        }
    }
    public Rectangle getRect(){
        return new Rectangle(getX(),getY(),sizeX,sizeY);
    }

    public void setWeapon(Weapon weapon){
        moveSpeed = 10;     //戴上武器之后跑得更慢
        this.weapon = weapon;
        this.weapon.setOwner(this);
        isArmed = true;
        this.weapon.appear();
    }
    public void unsetWeapon(){
        moveSpeed = 15;
        this.weapon.disappear();
        isArmed = false;
    }

    //分情况讨论各种碰撞
    private void collidesWithObjects(List<GameObject> objects){
        for(GameObject o: objects){
            if(o!=this){
                //与蛇发生碰撞
                if(o instanceof Snake && ((Snake) o).getRect().intersects(this.getRect())){
                    this.stay();((Snake) o).stay();
                }
            }
        }
    }

    public boolean isArmed() {
        return isArmed;
    }

    public void setArmed(boolean armed) {
        isArmed = armed;
    }

    public void getHit(){
        System.out.println("Get hit!");
    }
    //根据当前方向创建攻击动画
    /*private void createAtkAnimation(){
        if(direction!=Direction.Stop){
            int dirIndex = direction.ordinal();
            int timePerFrame = atkTime;
            List<KeyFrame> frames = new ArrayList<>();
            for(int i=0;i<atkImages[dirIndex].length;i++){
                frames.add(new KeyFrame(Duration.millis(timePerFrame), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(atkIndex >= atkImages[dirIndex].length)
                            atkIndex = 0;
                        currentImage = atkImages[dirIndex][atkIndex];

                        atkIndex ++;
                    }
                }));
            }

        }

    }*/
}
