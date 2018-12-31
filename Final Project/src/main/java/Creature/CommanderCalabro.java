package Creature;

import Bullet.Bullet;
import Formation.Formation;
import Instructor.Global;
import MyMap.MyPosition;
import ui.MenuController;

public class CommanderCalabro extends Creature {
    private CommanderCalabro(String name,String filename,int force,String skill){
        super(name,Global.CALABROS,Global.COMMANDER,filename,force,skill);
    }

    public static CommanderCalabro Grandpa = new CommanderCalabro("Grandpa","pa.jpg",8,"pas.png");

    @Override
    public void shootBullet(MyPosition pos){
        Bullet bullet = new Bullet(this,pos, Global.SPEEDLOW,Global.DAMAGEHIGH,20,5,"BLUEKNIFE.png");
        synchronized (MenuController.bullets) {
            MenuController.bullets.add(bullet);
        }
        MenuController.bulletexec.execute(bullet);
    }
    public void setFormationCalaBros(Formation formation, int coreX, int coreY){
        CalaBrosAdapter.CalaBros.get(0).getToSite(coreX,coreY);
        for(int i = 1;i < 7;i++){
            CalaBrosAdapter.CalaBros.get(i).getToSite(coreX+formation.relationX[i-1],coreY+formation.relationY[i-1]);
        }
        Grandpa.getToSite(coreX,coreY-2);
    }
}
