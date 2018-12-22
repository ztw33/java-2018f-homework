package Thread;

import Creatures.Scorpion;
import Source.Global;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ScorpionThread implements Runnable {

    //MARK:Properties
    Scorpion scorpion;
    Semaphore startSemaphore;
    Semaphore endSemaphore;
    int pos_x;
    int pos_y;

    //MARK:Initialize;
    public ScorpionThread(Semaphore begin,Semaphore end){
        scorpion = Global.scorpion;
        startSemaphore = begin;
        endSemaphore = end;
        pos_x = scorpion.getPos_x();
        pos_y = scorpion.getPos_y();
    }

    //MARK:Override
    @Override
    public void run(){
        while (true){
            try{
                startSemaphore.acquire();
                /* 蝎子进程开始战斗，移动 */
                if (scorpion.isAlive())
                    move();
                endSemaphore.release();
            }catch (Exception e){
                System.out.println("scorpion thread erro");
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
        pos_x = scorpion.getPos_x();
        pos_y = scorpion.getPos_y();

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
