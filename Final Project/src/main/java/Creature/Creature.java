package Creature;
import Bullet.Bullet;
import Instructor.Global;
import MyMap.MyMap;
import javafx.scene.image.Image;
import myfile.Act;
import MyMap.MyPosition;
import ui.MenuController;
import java.util.Random;
import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

public class Creature implements Runnable{
    protected Creature(){}
    public Creature(String name, int camp, int id, String filename,int force,String skillfile){
        this.name = name;
        this.camp = camp;
        this.identity = id;
        this.filename = filename;
        image = new Image(filename);
        die = new Image("die.jpg");
        this.sitex = -1;
        this.sitey = -1;
        this.hp = 100;
        this.force = force;
        this.alive = true;
        this.skillfile = skillfile;
        this.skill = new Image(skillfile);
    }

    private String skillfile;
    private Image skill;
    private int camp;
    int identity;
    String name;
    private String filename;
    private int sitex;
    private int sitey;
    private double hp;
    private int force;
    private Image image;
    private Image die;
    private boolean alive;

    public void setAlive(boolean x){alive = x;}
    public Image getDie(){return die;}
    public boolean ifAlive(){return alive;}
    public Image getImage(){return image;}
    public int getCamp(){return camp;}
    public String getName(){ return this.name;}
    public int getSitex(){
        return this.sitex;
    }
    public int getSitey(){
        return this.sitey;
    }
    void getToSite(int x, int y){
        MyMap.setSite(this,x,y);
    }
    public double getHp(){return hp;}
    public void setSitex(int x){this.sitex = x; }
    public void setSitey(int y){this.sitey = y; }
    public void setHp(int hp){this.hp = hp;}
    public int getForce(){return force;}
    public void exchangeSite(Creature anyone){
        int tempx = this.sitex;
        int tempy = this.sitey;
        this.sitex = anyone.sitex;
        this.sitey = anyone.sitey;
        anyone.sitex = tempx;
        anyone.sitey = tempy;
    }
    private int shoothz = Global.SHOOT_HZ;/*TODO init*/
    public void run(){
        while (hp > 0&&!MenuController.endGame){
            try {
                if(MenuController.playcontrol&&name=="Grandpa")
                    return;
                if (!Thread.currentThread().isInterrupted()){
                    sleep(4000 / (long) MenuController.myspeed);
                synchronized (MyMap.LandCreature) {
                    MyPosition pos = MyMap.getNearestEnemy(this, MyMap.LandCreature);
                    shoothz++;
                    if (shoothz >= Global.SHOOT_HZ) {
                        shootBullet(pos);
                        shoothz = 0;
                    }
                    synchronized (MenuController.bullets) {
                        if(Thread.currentThread().isInterrupted())
                            return;
                        avoidBullet();
                    }
                    synchronized (MenuController.acts) {
                        saveAct();
                    }
                    /*TODO 躲避弹幕函数*/
                    yield();
                }
            }else return;
            }
            catch (InterruptedException e){
                return;
            }
        }
    }
    private void saveAct(){
        boolean tempAlive = alive;
        String tempName = name;
        int action = Global.ACT_STAND;
        if(shoothz == 0)
            action = Global.ACT_SHOOT;
         Act act = new Act(tempName, action,tempAlive,sitex,sitey);
        MenuController.acts.add(act);
    }

    private void avoidBullet(){
        /*
        double[] list = {0,0,0,0,0};// up left mid right down
        for(Bullet x:MenuController.bullets){
            if(x.getExist()){
                if(x.getPos().x == sitex&&x.getPos().y == sitey-1)
                    list[0]+= x.getSpeed()/Bullet.getDistance(x.getPos().x,x.getPos().y,sitex,sitey-1);
                else if(x.getPos().x == sitex-1&&x.getPos().y == sitey)
                    list[1]+= x.getSpeed()/Bullet.getDistance(x.getPos().x,x.getPos().y,sitex-1,sitey);
                else if(x.getPos().x == sitex&&x.getPos().y == sitey)
                    list[2]+= x.getSpeed()/Bullet.getDistance(x.getPos().x,x.getPos().y,sitex,sitey);
                else if(x.getPos().x == sitex+1&&x.getPos().y == sitey)
                    list[3]+= x.getSpeed()/Bullet.getDistance(x.getPos().x,x.getPos().y,sitex+1,sitey);
                else if(x.getPos().x == sitex&&x.getPos().y == sitey+1)
                    list[4]+= x.getSpeed()/Bullet.getDistance(x.getPos().x,x.getPos().y,sitex,sitey+1);
            }
        }
        */
        if(alive)
            myMove();
    }

    private void myMove() {
        int max = 4;
        int min = 0;
        Random random = new Random();
        boolean flag = true;
        try {
            while (flag) {
                int rand = random.nextInt(max) % (max - min + 1) + min;
                if (rand == 0) {
                    if (sitey - 1 >= 0 && MyMap.LandCreature[sitey - 1][sitex].getName() == "none") {
                        MyMap.setSite(this, sitex, sitey - 1);
                        flag = false;
                    }
                } else if (rand == 1) {
                    if (sitex - 1 >= 0 && MyMap.LandCreature[sitey][sitex - 1].getName() == "none") {
                        MyMap.setSite(this, sitex - 1, sitey);
                        flag = false;
                    }
                } else if (rand == 2) {
                    MyMap.setSite(this, sitex, sitey);
                    flag = false;
                } else if (rand == 3) {
                    if (sitex + 1 < 20 && MyMap.LandCreature[sitey][sitex + 1].getName() == "none") {
                        MyMap.setSite(this, sitex + 1, sitey);
                        flag = false;
                    }
                } else {
                    if (sitey + 1 < 20 && MyMap.LandCreature[sitey + 1][sitex].getName() == "none") {
                        MyMap.setSite(this, sitex, sitey + 1);
                        flag = false;
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println(name);
            System.out.println(sitex+","+sitey);
        }
    }

    public void shootBullet(MyPosition pos){
        Bullet bullet = new Bullet(this,pos, Global.SPEEDNORMAL,Global.DAMAGENORMAL,20,5,"BLUEKNIFE.png");
        synchronized (MenuController.bullets) {
            MenuController.bullets.add(bullet);
        }
        MenuController.bulletexec.execute(bullet);
    }
/*
    public void useSkill(MyPosition pos){
        int x1 = pos.x;
        int y1 = pos.y-1;
        MyPosition pos1 = new MyPosition(x1,y1);
        int x2 = pos.x;
        int y2 = pos.y+1;
        MyPosition pos2 = new MyPosition(x2,y2);
        shootBullet(pos);
        shootBullet(pos1);
        shootBullet(pos2);
    }
*/
    private void goForward(){
        //MyPosition pos = MyMap.getNearestEnemy(this);
        synchronized (MyMap.LandCreature) {
            MyPosition pos = MyMap.getNearestEnemy(this,MyMap.LandCreature);
            System.out.print(name+" "+sitex+" "+sitey+" goto ");
            System.out.print(pos+" ");
            System.out.print(MyMap.LandCreature[pos.y][pos.x].getName()+" ");
            MyMap.moveTo(this,pos);
            System.out.println(name+" "+sitex+" "+sitey);
            //MyMap.printMap();
            yield();
        }
    }

    public void getDamage(int x){
        this.hp -= x;
        if(hp <= 0){
            alive = false;
        }
    }
    private void fight(){
        ;
    }
    @Override
    public String toString(){
        return name + " " + filename;
    }

}
