package backstage.creature.Audience;

import backstage.creature.Creature;

public class GrandFather extends Creature {
    public GrandFather(){
        name = "爷爷";
        imageUrl = "/common/images/audience/grandfather.png";
    }
    public void cheer(){
        System.out.println("爷爷助威：“孩子们加油啊！”");
    }
}
