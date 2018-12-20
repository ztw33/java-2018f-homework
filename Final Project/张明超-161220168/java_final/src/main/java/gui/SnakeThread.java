package gui;

import beings.BeingImage;
import beings.Grandfather;
import beings.Snake;
import formations.Battlefield;
import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class SnakeThread extends Snake implements Runnable {
    SnakeThread(Battlefield battlefield, MySemaphore mySemaphore){
        this.battlefield = battlefield;
        this.setMySemaphore(mySemaphore);
    }
    private boolean moveForward(){
        return battlefield.moveCreature(this.positionx-1, this.positiony, this);
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
}
