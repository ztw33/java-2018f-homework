import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Being {//生物
    protected Position pos;
    protected String name;
    protected boolean alive;
    protected int strength;
    public String viewURL;
    public ImageView view;
    public Being(){
        name="noname";
        pos=new Position(0,0);
        alive=true;
        view=null;
    }
    public Being(String name){
        this.name=name;
        pos=new Position(0,0);
        alive=true;
        view=null;
        strength=0;
    }
    public Being(String name, int str){
        this.name=name;
        pos=new Position(0,0);
        alive=true;
        view=null;
        strength=str;
    }
    public Being(String name,String imageURL,int str){
        viewURL=imageURL;
        this.name=name;
        pos=new Position(0,0);
        alive=true;
        //System.out.println("initialize "+name+" url: "+imageURL);
        Image image=new Image(imageURL);
        view = new ImageView();
        view.setImage(image);
        view.setPreserveRatio(true);
        view.setFitWidth(40);
        strength=str;
    }
    public final String getName() {
        return name;
    }
    public final Position getPos(){
        return pos;
    }
    public void changePos(int x, int y){
        pos.changePos(x,y);
    }
    public void changePos(Position pos){
        this.pos.changePos(pos.getX(),pos.getY());
    }
    public boolean isAlive(){
        return alive;
    }
    public void kill(){
        alive=false;
    }
    public void revive(){
        alive=true;
    }
    public int getStrength(){
        return strength;
    }
}
class GoodBeing extends Being{
    GoodBeing(){
        name="noname";
        pos=new Position(0,0);
    }
    GoodBeing(String name){
        super(name);
    }
    GoodBeing(String name,int str){
        super(name,str);
    }
    GoodBeing(String name, String imageURL,int str){
        super(name,imageURL,str);
    }
}
class EvilBeing extends Being{
    EvilBeing(){
        name="noname";
        pos=new Position(0,0);
    }
    EvilBeing(String name,int str){
        super(name,str);
    }
    EvilBeing(String name, String imageURL,int str){
        super(name,imageURL,str);
    }
}