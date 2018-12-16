package gui;

import beings.BeingImage;
import beings.CalabashBrother;
import beings.Grandfather;
import formations.Battlefield;
import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.concurrent.Semaphore;

public class CalabashThread extends CalabashBrother implements Runnable{

    CalabashThread(Battlefield battlefield, int i, MySemaphore mySemaphore){
        super(i);
        this.setMySemaphore(mySemaphore);
        this.battlefield = battlefield;
        //this.roundTimer = roundTimer;
    }
    private boolean moveForward(){
        return battlefield.moveCreature(this.positionx+1, this.positiony, this);
    }
    public void run(){
        while(true) {
            try{
                mySemaphore.roundStartAcquire();
                if(!moveForward()){
                    mySemaphore.animationEndRelease();
                }
            }catch (Exception e){
                //do nothing
            }
        }
    }

    private Battlefield battlefield;
    //private RoundTimer roundTimer;
}
