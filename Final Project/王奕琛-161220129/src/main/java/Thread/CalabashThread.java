package Thread;

import Creatures.Calabash;
import Source.Global;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CalabashThread implements Runnable {

    //MARK:Properties；
    Calabash calabash;
    Semaphore startSemaphor;
    Semaphore endSemaphor;
    int pos_x;
    int pos_y;

    //MARK:Initialize
    public CalabashThread(int i,Semaphore begin,Semaphore end){
        calabash = Global.calabashBrother.getCalabash(i);
        startSemaphor = begin;
        endSemaphor = end;
        pos_x = calabash.getPos_x();
        pos_y = calabash.getPos_y();
    }

    //MARK:override function
    @Override
    public void run(){
        while (true){
            try {
                startSemaphor.acquire();
                /* 葫芦娃进程开始战斗，移动 */
                if(calabash.isAlive())
                    move();
                endSemaphor.release();
            }catch (Exception e){
                System.out.println("calabash thread erro");
            }
        }
    }

    //MARK:help methods

    //move;
    public void move(){

        //获取随机方向
        Random random = new Random();
        int i = random.nextInt(3);
        boolean flag = false;
        pos_x = calabash.getPos_x();
        pos_y = calabash.getPos_y();

        //向某一可以移动的方向移动，或有可能原地不动；
        switch (i){
            case 0:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x-1,pos_y);
                if(flag)
                    break;
                i++;
            }
            case 1:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x,pos_y-1);
                if(flag)
                    break;
                i++;
            }
            case 2:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x+1,pos_y);
                if(flag)
                    break;
                i++;
            }
            case 3:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x,pos_y+1);
                break;
            }
        }
    }


}
