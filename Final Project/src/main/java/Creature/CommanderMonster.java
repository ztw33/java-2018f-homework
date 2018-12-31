package Creature;
import Bullet.Bullet;
import Formation.Formation;
import Instructor.Global;
import MyMap.MyPosition;
import ui.MenuController;

public class CommanderMonster extends Creature {
    private CommanderMonster(String name,String filename,int force,String skill){
        super(name,Global.MONSTER,Global.COMMANDER,filename,force,skill);
    }

    public static final CommanderMonster Serpent = new CommanderMonster("Serpent","snake.jpg",8,"snakes.png");

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
        Bullet bullet = new Bullet(this,pos, Global.SPEEDFAST*speeddiff,Global.DAMAGELOW*damagediff,20,5,"REDKNIFE.png");
        synchronized (MenuController.bullets) {
            MenuController.bullets.add(bullet);
        }
        MenuController.bulletexec.execute(bullet);
    }
    public void setFormationMonster(Formation formation, int coreX, int coreY){
        Monster.Scorpion.getToSite(coreX,coreY);
        for(int i = 0;i < 8; i++){
            MonsterAdapter.mices.get(i).getToSite(coreX+formation.relationX[i],coreY+formation.relationY[i]);
        }
        Serpent.getToSite(coreX,coreY-2);
    }

}
