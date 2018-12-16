package gui;

import java.util.concurrent.Semaphore;

public class MySemaphore {
    MySemaphore(int i, int j){
        semaphoreAnimationEnd = new Semaphore(i);
        semaphoreRoundStart = new Semaphore(j);
    }
    public Semaphore semaphoreAnimationEnd;
    public Semaphore semaphoreRoundStart;
    public void roundStartAcquire() {
        try{
            semaphoreRoundStart.acquire();
        }catch (Exception e){
            //System.out.println("semaphoreRoundStart acquire fail");
            //assert (false);
        }
    }

    public void animationEndAcquire() {
        try{
            //System.out.println(semaphoreAnimationEnd);
            semaphoreAnimationEnd.acquire();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("animationEnd acquire fail");
            //assert(false);
            //System.exit(-1);
        }
    }
    public void animationEndRelease(){
        semaphoreAnimationEnd.release();
    }
    public void roundStartRelease(){
        semaphoreRoundStart.release();
    }
}
