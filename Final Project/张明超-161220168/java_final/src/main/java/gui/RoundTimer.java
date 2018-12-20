package gui;

import beings.BeingImage;
import formations.Battlefield;

import java.util.concurrent.Semaphore;

public class RoundTimer implements Runnable{
    private MySemaphore[] semaphoresList;
    private Battlefield battlefield;
    RoundTimer(MySemaphore[] semaphoresList, Battlefield battlefield){
        this.semaphoresList = semaphoresList;
        this.battlefield = battlefield;
    }
    public void run(){
        int count = 0;
        while(true){
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            for(int i = 0; i < semaphoresList.length; i++){
                //System.out.println("animation acquire:"+i+"now");
                System.out.println(semaphoresList[i].semaphoreAnimationEnd);
                semaphoresList[i].animationEndAcquire();
                System.out.println("animation acquire:"+i+"success");
            }

            for(int i = 0; i < semaphoresList.length; i++){
                semaphoresList[i].roundStartRelease();
                System.out.println("roundStart release:"+i);
            }
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            battlefield.printFieldText();
            System.out.println("round:" + count+"----------------------------------------------------------------------");
            count++;
        }
    }
}
