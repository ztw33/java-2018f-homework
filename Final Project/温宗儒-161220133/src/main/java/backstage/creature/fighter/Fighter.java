package backstage.creature.fighter;

import backstage.battleGround.Position;
import backstage.battleGround.Space;
import backstage.creature.Creature;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.ImgetSetter;

public abstract class Fighter extends Creature implements ImgetSetter {
    protected String attackUrl;
    protected ImageView green;
    private ImageView red;

    protected int attack;  //攻击力
    protected int maxhp;
    protected int hp;     //血量
    protected int defense; //防御力
    protected boolean remoteAttack; //近战还是远程攻击


    //初始化时创建图片对象
    public void setImageView(){
        super.setImageView();
        green = new ImageView(new Image("/common/images/blood/green.jpg"));
        green.setFitWidth(30);
        green.setFitHeight(5);
        red = new ImageView(new Image("/common/images/blood/red.jpg"));
        red.setFitWidth(30);
        red.setFitHeight(5);
    }
    //攻击时生物的图片
    public void setAttackImageView(){
        imageView.setImage(new Image(attackUrl));
    }
    //攻击结束后生物的图片
    public void setImageBack(){
        imageView.setImage(new Image(imageUrl));
    }
    //设置图片位置
    public void setImageViewLocation(){
        super.setImageViewLocation();
        green.setLayoutX(locationY*30);
        green.setLayoutY(locationX*30);
        red.setLayoutX(locationY*30);
        red.setLayoutY(locationX*30);
    }
    //生物死后
    public void cleanImageView(){
        imageView.setVisible(false);
        green.setVisible(false);
        red.setVisible(false);
    }

    //被攻击
    public void beAttacked(int attack){
        int hurt = attack - defense;
        if(hurt < 0) hurt = 0;
        this.hp -= hurt;
        if(hp<0) {
            hp = 0;
            Space.addText(name + "减去" + hurt +"点血，当前生命值" + hp + ","+ name+"被击杀\n");
        }else {
            Space.addText(name + "减去" + hurt +"点血，当前生命值" + hp + "\n");
        }
        double nowLength = ((double)hp/maxhp)*30;
        if(nowLength <=0){
            green.setFitWidth(0.1);
        }else {
            green.setFitWidth(nowLength);
        }
    }
    public void move(Position[][] position, int toX, int toY){
        int locationx = locationX;
        int locationy = locationY;
        position[locationx][locationy].clean();
        position[toX][toY].setCreature(this,toX,toY);
    }

    public ImageView getGreen() { return green; }
    public ImageView getRed() { return red; }
    public boolean notDead(){ return hp > 0; }
}
