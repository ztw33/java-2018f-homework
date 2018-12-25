package Thing;

import Character.Snake;
import Animation.MyAnimation;
import Animation.WeaponAnimation;
import Enums.Direction;
import Enums.Status;
import Frame.GameObject;
import Main.GameAdmin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class IceSword extends Weapon {
    private Direction direction;
    private Image currentImage;
    private double zoomRatio = 1.0;
    private int locX , locY ;
    private int sizeX, sizeY;
    private int preX, preY;
    private static Image[] standImages = null;
    private static Image[][] moveImages = null;
    public static Image[][] atkImages = null;
    private static int[][] standModify = null;
    private static int[][][] moveModify = null;
    public static int[][][] atkModify = null;

    public IceSword(int x, int y, Direction direction, boolean good,GameAdmin admin){
        super(x,y,50,50,good,admin);
        this.direction = direction;
        this.currentImage = standImages[direction.ordinal()];
        locX = x;locY = y;
        setVisible(false);
    }
    //初始化各种形象
    static{
        try {
            standImages = new Image[]{
                    new Image(new FileInputStream(wd + "\\resources\\weapon1\\stand\\right.png")),
                    new Image(new FileInputStream(wd + "\\resources\\weapon1\\stand\\left.png")),
                    new Image(new FileInputStream(wd + "\\resources\\weapon1\\stand\\up.png")),
                    new Image(new FileInputStream(wd + "\\resources\\weapon1\\stand\\down.png"))
            };
            moveImages = new Image[][]{
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveLeft1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveLeft2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveLeft3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveLeft4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveLeft5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveLeft6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveRight1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveRight2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveRight3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveRight4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveRight5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveRight6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveUp1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveUp2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveUp3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveUp4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveUp5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveUp6.png"))
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveDown1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveDown2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveDown3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveDown4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveDown5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\move\\moveDown6.png"))
                    }
            };
            atkImages = new Image[][]{
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkLeft2.png")),
                            standImages[Direction.Left.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkRight2.png")),
                            standImages[Direction.Right.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkUp2.png")),
                            standImages[Direction.Up.ordinal()]
                    },
                    {
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown1.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown2.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown3.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown5.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown6.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown4.png")),
                            new Image(new FileInputStream(wd + "\\resources\\weapon1\\atk\\atkDown2.png")),
                            standImages[Direction.Up.ordinal()]
                    }
            };

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //初始化坐标修正矩阵
    static{
        standModify = new int[][]{
                new int[]{-27,0},
                new int[]{-27,0},
                new int[]{2,33},
                new int[]{-37,-20}
        };
        moveModify = new int[][][]{
                new int[][]{
                        {10,-5},{-5,-5},{-5,-8},{0,0},{10,-3},{10,-3}
                },
                new int[][]{
                        {5,-5},{10,-5},{20,-5},{10,0},{0,0},{10,-5}
                },
                new int[][]{
                        {-12,45},{-2,40},{-2,40},{0,45},{-3,50},{-8,48}
                },
                new int[][]{
                        {-50,-25},{-60,-28},{-60,-25},{-60,-20},{-60,-23},{-57,-25}
                }
        };
        atkModify = new int[][][]{
                new int[][]{
                        {-5,20},{-3,18},{30,30},{23,13},{-28,-25},{30,-15},{23,13},{-3,18},{-27,0}
                },
                new int[][]{
                        {-30,25},{-83,18},{-24,30},{-20,10},{25,-25},{17,-15},{-20,10},{-83,18},{-27,0}
                },
                new int[][]{
                        {22,17},{-63,37},{-28,52},{-20,47},{-80,-23},{-82,-7},{-20,47},{-63,37},{2,33}
                },
                new int[][]{
                        {-75,45},{-80,-20},{-90,-10},{-80,40},{-30,-22},{38,-22},{-80,40},{-80,-20},{-37,-20}
                }
        };
    }


    public void stand() {
        currentImage = standImages[direction.ordinal()];
        locX = this.owner.getX()+standModify[direction.ordinal()][0];
        locY = this.owner.getY()+standModify[direction.ordinal()][1];
    }

    public void stay() {
        setX(preX);setY(preY);
    }


    public void move(Direction direction, int speed, int imageIndex) {
        preX = getX();preY = getY();
        currentImage = moveImages[direction.ordinal()][imageIndex];
        int xModify = moveModify[direction.ordinal()][imageIndex][0];
        int yModify = moveModify[direction.ordinal()][imageIndex][1];
        switch (direction){
            case Left:{
                setX(getX()-speed);
                break;
            }
            case Right:{
                setX(getX()+speed);
                break;
            }
            case Up:{
                setY(getY()-speed);
                break;
            }
            case Down:{
                setY(getY()+speed);
                break;
            }
        }
        locX = this.owner.getX()+xModify; locY = this.owner.getY()+yModify;
    }

    public MyAnimation attack(Direction direction, int time){
        return new WeaponAnimation(this.admin.getGraphicsContext2D(),this.owner.getX(),this.owner.getY(),
                time,atkImages[direction.ordinal()],atkModify[direction.ordinal()]);
    }

    public void collidesWithObjects(List<GameObject> objects) {
        for(int i=0;i<objects.size();i++){
            GameObject o = objects.get(i);
            if(o!=this){
                if(o instanceof Snake && ((Snake) o).getRect().intersects(this.getRect())){
                    this.stay();
                }
            }
        }
    }
    public Rectangle getRect(){
        return new Rectangle(locX,locY,sizeX,sizeY);
    }

    @Override
    public void appear(){
        this.setVisible(true);
        if(owner!=null && owner.getStatus() == Status.Standing){
            setX(this.owner.getX());
            setY(this.owner.getY());
            locX = getX() + standModify[owner.getDirection().ordinal()][0];
            locY = getY() + standModify[owner.getDirection().ordinal()][1];
        }
    }
    @Override
    public void disappear(){
        this.setVisible(false);
        this.owner = null;
    }
    @Override
    public void draw(GraphicsContext gc) {
        sizeX = (int)(currentImage.getWidth()*zoomRatio);
        sizeY = (int)(currentImage.getHeight()*zoomRatio);
        gc.drawImage(currentImage,locX,locY,sizeX,sizeY);

        collidesWithObjects(this.admin.getObjectList());
    }

    @Override
    public void update() {

    }
}
