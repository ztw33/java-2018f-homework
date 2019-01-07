package backstage.creature.Audience;

import backstage.creature.Creature;

public class Snake extends Creature {
    public Snake(){
        name = "蛇精";
        imageUrl = "/common/images/audience/snake.jpg";
    }
    public void cheer(){
        System.out.println("蛇精助威：“小的们加油！”");
    }
}
