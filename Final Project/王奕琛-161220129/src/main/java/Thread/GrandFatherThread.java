package Thread;

import Creatures.GrandFather;
import Source.Global;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GrandFatherThread implements Runnable {

    //MARK:Properties
    GrandFather grandFather = Global.grandFather;
    Semaphore startSemaphore;
    Semaphore endSemaphore;
    int pos_x;
    int pos_y;

    //MARK:Initialize
    public GrandFatherThread(Semaphore begin,Semaphore end){
        startSemaphore = begin;
        endSemaphore = end;
        pos_x = Global.grandFather.getPos_x();
        pos_y = Global.grandFather.getPos_y();
    }

    //MARK:Override function
    @Override
    public void run() {

        while (true){
            try{
                startSemaphore.acquire();
                /* 爷爷进程开始战斗，移动等 */
                //if(grandFather.isAlive())
                    //battle();
                if(grandFather.isAlive())
                    move();
                endSemaphore.release();
            }catch (Exception e){
                System.out.println("grandfatherthread erro");
            }

        }
    }

    //MARK: help methods

    //move
    public void move(){

        //获取随机方向
        Random random = new Random();
        int i = random.nextInt(3);
        boolean flag = false;
        pos_x = grandFather.getPos_x();
        pos_y = grandFather.getPos_y();

        //向某一可以移动的方向移动，或有可能原地不动；
        switch (i){
            case 0:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x+1,pos_y);
                if(flag)
                    break;
                i++;
            }
            case 1:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x,pos_y+1);
                if(flag)
                    break;
                i++;
            }
            case 2:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x-1,pos_y);
                if(flag)
                    break;
                i++;
            }
            case 3:{
                flag = Global.map.moveCreature(pos_x,pos_y,pos_x,pos_y-1);
                break;
            }
        }
    }

}
