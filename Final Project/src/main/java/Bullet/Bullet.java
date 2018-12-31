package Bullet;

import Creature.Creature;
import Instructor.Global;
import MyMap.MyMap;
import MyMap.MyPosition;
import javafx.scene.image.Image;
import ui.MenuController;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

public class Bullet implements Runnable{
    private int length;
    private int height;
    private double sitex;
    private double sitey;
    private double judgex;
    private double judgey;
    private double speed;
    private int camp;
    private int damage;
    private MyPosition pos;
    private double posx,posy;
    private boolean exist;
    private double mysin;
    private double mycos;
    private double myangle;
    private String filename;
    private Image image;
    private static double offset = MenuController.imageSize;
    public Bullet(Creature creature,MyPosition position,double speed,int damage,int length,int height,String filename){
        this.filename = filename;
        image = new Image(filename);
        this.length = length;
        this.height = height;
        this.speed = speed;
        this.damage = damage;
        this.camp = creature.getCamp();
        this.sitex = creature.getSitex()*offset + offset/2;
        this.sitey = creature.getSitey()*offset + offset/2;

        this.pos = position;
        posx = pos.x*offset + offset/2;
        posy = pos.y*offset + offset/2;
        this.exist = true;

        double dis = getDistance(sitex,sitey,posx,posy);
        mycos = (posx - sitex)/dis;
        mysin = (sitey - posy)/dis;
        myangle = setAngle(mysin,mycos);
        this.judgex = sitex + 0.5*length*mycos;
        this.judgey = sitey + 0.5*length*mysin;
    }
    public Image getImage(){return image;}
    public boolean getExist(){
        return exist;
    }
    public int getCamp(){
        return camp;
    }
    public double getSitex(){return sitex;}
    public double getSitey(){return sitey;}
    public double getLength(){return length;}
    public double getHeight(){return height;}
    public double getAngle(){return myangle;}
    @Override
    public void run(){
        while (exist) {
            if(!Thread.currentThread().isInterrupted()) {
                try {
                    sleep(200 / (long) MenuController.myspeed);
                    synchronized (MenuController.bullets) {
                        if (MenuController.endGame)
                            return;
                        goForward();
                        judgeBullet();
                        judgeSelf();
                        yield();
                    }
                } catch (InterruptedException e) {
                    //System.out.println("Bullet interrupt");
                    return;
                }
            }
            else return;
        }
    }
    private void judgeSelf(){
        if(sitex<0||sitey<0||sitex>600||sitey>600)
            exist = false;
    }
    private void goForward(){
        double changey = speed * mysin;
        double changex = speed * mycos;
        judgex += changex;
        judgey -= changey;
        sitex += changex;
        sitey -= changey;
    }

    private void judgeBullet(){
        double t1 = Math.round(judgex/offset);
        double t2 = Math.round(judgey/offset);
        int x = (int)t1;
        int y = (int)t2;
        ArrayList<Creature> creatures = MyMap.getNearCreatures(x,y);
        for(Creature creature: creatures)
            if(creature.getName()!="none")
                if(creature.getCamp()!= camp&&creature.getHp()>0){
                    double tx = creature.getSitex()*offset + offset/2;
                    double ty = creature.getSitey()*offset + offset/2;
                    double dis = getDistance(tx,ty,judgex,judgey);
                    if(dis < Global.SHOOTDIS) {
                        causeDamage(creature);
                        break;
                    }
                }
    }

    private void causeDamage(Creature creature){
        creature.getDamage(damage);
        System.out.println("cause damage to "+creature.getName());
        exist = false;
    }

    public boolean shootCreature(Creature anyone){
        double x = anyone.getSitex()* MenuController.imageSize;
        double y = anyone.getSitey()* MenuController.imageSize;
        double distance = getDistance(x,y,judgex,judgey);
        return distance < Global.SHOOTDIS;
    }

    static double getDistance(double x1,double y1,double x2,double y2){
        double res = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        res = Math.sqrt(res);
        res = Math.abs(res);
        return res;
    }

    private double setAngle(double sin,double cos){
        double abssin = Math.abs(sin);
        double pi = Math.asin(abssin);
        if(sin>=0&&cos>=0)
            return pi*180/Math.PI;
        else if(sin>0&&cos<0)
            return 180-pi*180/Math.PI;
        else if(sin<=0&&cos<=0)
            return pi*180/Math.PI+180;
        else if(sin<0&&cos>0)
            return 360-pi*180/Math.PI;
        else {
            System.out.println("setAngle fault");
            return 0;
        }
    }
}
