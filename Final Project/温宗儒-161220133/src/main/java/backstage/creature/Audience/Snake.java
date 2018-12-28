package backstage.creature.Audience;

import backstage.battleGround.Space;
import backstage.creature.Creature;
import util.Cheer;
/**
 * @program: gourdBoys
 * @description: Object Snake
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class Snake extends Creature implements Cheer{
    private static Snake instance;
    public static Snake getInstance(){
        if(instance == null){
            instance = new Snake();
        }
        return instance;
    }
    private Snake(){
        name = "蛇精";
        imageUrl = "/common/images/audience/snake.jpg";
        setImageView();
    }
    public void cheer(){
        Space.addText("蛇精助威：“小的们加油！”\n");
    }
}
