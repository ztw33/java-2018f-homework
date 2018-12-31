package Creature;

import Bullet.Bullet;
import Instructor.Global;
import MyMap.MyPosition;
import ui.MenuController;

public class Monster extends Creature {
    Monster(String name,String filename,int force,String skill){
        super(name,Global.MONSTER,Global.NORMARL,filename,force,skill);
        if(name.equals("Scorpion"))
            this.identity = Global.LEADER;
    }
    @Override
    public void shootBullet(MyPosition pos){
        int speeddiff,damagediff;
        if(MenuController.currentDiff==1){
            speeddiff = Global.S_DIFF_EASY;
            damagediff = Global.S_DIFF_EASY;
        }
        else if(MenuController.currentDiff==2){
            speeddiff = Global.S_DIFF_NORMAL;
            damagediff = Global.S_DIFF_NORMAL;
        }
        else {
            speeddiff = Global.S_DIFF_HARD;
            damagediff = Global.S_DIFF_HARD;
        }
        Bullet bullet = new Bullet(this,pos, Global.SPEEDNORMAL*speeddiff,Global.DAMAGENORMAL*damagediff,20,5,"REDCIRCLE.png");
        synchronized (MenuController.bullets) {
            MenuController.bullets.add(bullet);
        }
        MenuController.bulletexec.execute(bullet);
    }

    public static final Monster Scorpion = new Monster("Scorpion","sco.jpg",8,"scos.png");
}
