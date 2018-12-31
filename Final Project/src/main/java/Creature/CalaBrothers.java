package Creature;
import Bullet.Bullet;
import Instructor.Global;
import MyMap.MyPosition;
import ui.MenuController;


public class CalaBrothers extends Creature {

    CalaBrothers(int rank,String color,String name,String filename,int force,String skill){
        super(name, Global.CALABROS, Global.NORMARL,filename,force,skill);
        this.rank = rank;
        this.color = color;
        if(rank == 1)
            this.identity = Global.LEADER;
        this.site = rank - 1;
    }

    private final int rank;
    private final String color;
    private int site;

    public int getRank() {
        return this.rank;
    }
    public int getSite(){
        return this.site;
    }
    public void number_Off(CalaBrothers bro){
        System.out.print(this.name);
        System.out.print(this.site);
        System.out.print("->");
        System.out.println(bro.site);
    }
    @Override
    public void shootBullet(MyPosition pos){
        Bullet bullet = new Bullet(this,pos, Global.SPEEDNORMAL,Global.DAMAGEHIGH,20,5,"BLUECIRCLE.png");
        synchronized (MenuController.bullets) {
            MenuController.bullets.add(bullet);
        }
        MenuController.bulletexec.execute(bullet);
    }
    public void color_Call(){
        System.out.println(this.color);
    }

}
