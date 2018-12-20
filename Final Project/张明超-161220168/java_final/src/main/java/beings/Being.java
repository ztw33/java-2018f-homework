package beings;

import gui.MySemaphore;
import javafx.scene.image.ImageView;

public class Being {
    public Being(){

    }
    public void toldname() {
        System.out.print(name);
    }
    public int getPositionx(){
        return positionx;
    }
    public int getPositiony(){
        return positiony;
    }
    public ImageView getImageView(){
        return imageView;
    }
    public void setImageView(BeingImage imageId){
        this.imageView = new ImageView(imageId.getImage());
        imageView.setFitHeight(74);
        imageView.setFitWidth(74);
    }
    public void setMySemaphore(MySemaphore mySemaphore){
        this.mySemaphore = mySemaphore;
    }
    public MySemaphore getMySemaphore(){
        return mySemaphore;
    }
    public void setPosition(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
    }
    protected String name;
    protected int positionx = 0;
    protected int positiony = 0;
    protected ImageView imageView;
    protected MySemaphore mySemaphore;
}
