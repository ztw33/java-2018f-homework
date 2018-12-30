package com.company.Creature;

import com.company.BattleField.BattleField;
import java.io.Serializable;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Creature implements Runnable, Serializable {
    private static BattleField BattleFieldcreature;
    private static int em = 0;
    protected String name;
    private int x;
    private int y;
    private boolean isalive=true;
    protected boolean goodcreature = true;
    public Creature(){
        name="NULL";
    }
    public Creature(String a ){
        name= a;
    }

    public Creature(Creature creature) {
        name=creature.name;
        x=creature.x;
        y=creature.y;
        isalive=creature.isalive;
        goodcreature=creature.goodcreature;
    }

    public static BattleField getBattleFieldcreature() {
        return BattleFieldcreature;
    }

    public static void setBattleFieldcreature(BattleField bf) {
        BattleFieldcreature=bf;
    }

    public void cheers(){
            System.out.print("Cheers");
    }
    public void creaturePrintName(){
        if(isalive)
            System.out.print(name+" ");
        else
            System.out.print("dead  ");
    }
    public void setXY(int X,int Y){
        x=X;
        y=Y;
    }
    @Override
    public void run() {
        while(isalive&&BattleFieldcreature.getgoodnum()>0&&BattleFieldcreature.getbadnum()>0){
            synchronized(this) {
                System.out.println(em);
                    if(em<4){
                    System.out.println("--------------------------线程开始"+currentThread().getId()+"  "+name);
                    if (x < 9 &&BattleFieldcreature.getField()[x + 1][y].creature.isalive&& !BattleFieldcreature.getField()[x + 1][y].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x + 1][y].creature.goodcreature) {
                        fight(BattleFieldcreature.getField()[x + 1][y].creature);
                    } else if (y < 16 &&BattleFieldcreature.getField()[x ][y+1].creature.isalive&& !BattleFieldcreature.getField()[x][y + 1].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x][y + 1].creature.goodcreature) {
                        fight(BattleFieldcreature.getField()[x][y + 1].creature);
                    } else if (x > 0 &&BattleFieldcreature.getField()[x - 1][y].creature.isalive&& !BattleFieldcreature.getField()[x - 1][y].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x - 1][y].creature.goodcreature) {
                        fight(BattleFieldcreature.getField()[x - 1][y].creature);
                    } else if (y > 0 &&BattleFieldcreature.getField()[x ][y-1].creature.isalive&& !BattleFieldcreature.getField()[x][y - 1].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x][y - 1].creature.goodcreature) {
                        fight(BattleFieldcreature.getField()[x][y - 1].creature);
                    } else if(!walk()){
                        em++;
                    }
                   }
                    else{
                        em = 0;
                        ramdomwalk();
                    }
                }
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("--------------------------线程暂停"+currentThread().getId()+"  "+name);
            }
        System.out.println("--------------------------线程结束"+currentThread().getId()+"  "+name);

    }
    public int hasenemy() {
        if (x >0) {
            for (int i = 1; x - i>= 0; i++) {
                if (!BattleFieldcreature.getField()[x - i][y].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x - i][y].creature.goodcreature&&BattleFieldcreature.getField()[x -i][y ].creature.isalive)
                    return 1;//左边有敌人
            }
        }
        if (y >0) {
            for (int i = 1; y -i > 0; i++) {
                if (!BattleFieldcreature.getField()[x ][y -i].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x ][y-i].creature.goodcreature&&BattleFieldcreature.getField()[x ][y -i].creature.isalive)
                    return 3;//上边有敌人
            }
        }
            for (int i = 0; x + i < 8; i++) {
                if (!BattleFieldcreature.getField()[x + i][y].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x + i][y].creature.goodcreature&&BattleFieldcreature.getField()[x +i][y ].creature.isalive)
                    return 2;//右边有敌人
            }
            for (int i = 0; y +i < 17; i++) {
                if (!BattleFieldcreature.getField()[x ][y +i].creature.name.equals("NULL") && this.goodcreature != BattleFieldcreature.getField()[x ][y+i].creature.goodcreature&&BattleFieldcreature.getField()[x ][y +i].creature.isalive)
                    return 4;//下边有敌人
            }
        return 0;
    }
    public void ramdomwalk(){
        int tempx=x,tempy=y;
        int changex=x,changey=y;
        if ((int)(1+Math.random()*(10-1+1))%2==0){
        for(int i=1;y+i<18;i++){
            changey=y+i;
            if(BattleFieldcreature.getField()[changex][changey].creature.name.equals("NULL")) {
                BattleFieldcreature.getField()[changex][changey].creature = this;
                BattleFieldcreature.getField()[tempx][tempy].creature = new Creature();
                x = changex;
                y = changey;
                return;
            }
        }}
        else{
        for(int i=1;x+i<10;i++){
            changex=x+i;
            if(BattleFieldcreature.getField()[changex][changey].creature.name.equals("NULL")) {
                BattleFieldcreature.getField()[changex][changey].creature = this;
                BattleFieldcreature.getField()[tempx][tempy].creature = new Creature();
                x = changex;
                y = changey;
                return;
            }
        }
        }

    }

    public boolean walk() {
        int tempx=x,tempy=y;
        int changex=x,changey=y;
        switch (hasenemy()){
            case 1:for(int i=x;i>=0;i--){
                changex=i;
                if(BattleFieldcreature.getField()[changex][changey].creature.name.equals("NULL")) {
                    BattleFieldcreature.getField()[changex][changey].creature = this;
                    BattleFieldcreature.getField()[tempx][tempy].creature = new Creature();
                    x = changex;
                    y = changey;
                    return true;
                }
            };break;
            case 2:for(int i=x;i<10;i++){
                changex=i;
                if(BattleFieldcreature.getField()[changex][changey].creature.name.equals("NULL")) {
                    BattleFieldcreature.getField()[changex][changey].creature = this;
                    BattleFieldcreature.getField()[tempx][tempy].creature = new Creature();
                    x = changex;
                    y = changey;
                    return true;
                }
            };break;
            case 3:for(int i=y;i>=0;i--){
                changey=i;
                if(BattleFieldcreature.getField()[changex][changey].creature.name.equals("NULL")) {
                    BattleFieldcreature.getField()[changex][changey].creature = this;
                    BattleFieldcreature.getField()[tempx][tempy].creature = new Creature();
                    x = changex;
                    y = changey;
                    return true;
                }
            };break;
            case 4:for(int i=y;i<18;i++){
                changey=i;
                if(BattleFieldcreature.getField()[changex][changey].creature.name.equals("NULL")) {
                    BattleFieldcreature.getField()[changex][changey].creature = this;
                    BattleFieldcreature.getField()[tempx][tempy].creature = new Creature();
                    x = changex;
                    y = changey;
                    return true;
                }
            };break;
            case 0:return false;
        }
        return true;
    }

    public void fight(Creature a){
        if(isalive&&a.isalive){
        if((int)(1+Math.random()*(10-1+1))%2==0){
            isalive=false;
            if(this.goodcreature)
                BattleFieldcreature.setgoodnumminus();
            else
                BattleFieldcreature.setbadnumminus();
        }
        else{
            a.isalive=false;
            if(a.goodcreature)
                BattleFieldcreature.setgoodnumminus();
            else
                BattleFieldcreature.setbadnumminus();
        }
        }
    }

    public String getname() {
        return name;
    }

    public boolean getisalive() {
        return  isalive;
    }
}

class HuluBrother extends Creature{
    private Human HumanHulu;
    private Color color;

    HuluBrother(){
        HumanHulu = Human.ONE;
        name = HumanHulu.getName();
        color = HumanHulu.getColor();
    }
    HuluBrother(int i){
        for (Human c : Human.values()) {
            if (c.ordinal() == i) {
                HumanHulu = c;
            }
        }
        name = HumanHulu.getName();
        color = HumanHulu.getColor();
    }
    public int tellOrdinal(){
        return HumanHulu.ordinal();
    }
    public void huluTellColor(){
        System.out.println(HumanHulu.getColor());
    }//输出颜色
    public void huluTellName(){
        System.out.println(HumanHulu.getName());
    }//输出名字

    public Color getcolor() {
        return color;
    }
}


class  LouLuo extends Creature{
    LouLuo(){
        super("小喽啰");
        goodcreature = false;
    }

}

class XieZi extends Creature{
    XieZi(){
        super("蝎子精");
        goodcreature = false;
    }
}

