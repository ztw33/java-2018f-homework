package backstage.creature.Audience;

import backstage.battleGround.Space;
import backstage.creature.Creature;
import util.Cheer;
/**
 * @program: gourdBoys
 * @description: Object grandFather
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class GrandFather extends Creature implements Cheer {
    private static GrandFather instance;
    public static GrandFather getInstance(){
        if(instance == null){
            instance = new GrandFather();
        }
        return instance;
    }
    private GrandFather(){
        name = "爷爷";
        imageUrl = "/common/images/audience/grandfather.png";
        setImageView();
    }
    public void cheer(){
        Space.addText("爷爷助威：“孩子们加油啊！”\n");
    }
}
