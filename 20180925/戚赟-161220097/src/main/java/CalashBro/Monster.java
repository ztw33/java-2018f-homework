package CalashBro;
import javafx.scene.image.Image;


public class Monster extends Creature{
    Monster()
    {
        super(-1,-1);
        nature = false;
    }
}

class Snake extends Monster
{
    public Snake()
    {
        super();
        this.name = "蛇精";
        this.image =  new Image(getClass().getClassLoader().getResource("pic/snake.jpg").toString()
                ,50,50,false,false);
    }
}

class Scorpion extends Monster
{
    public Scorpion()
    {
        super();
        this.name = "蝎子精";
        this.image =  new Image(getClass().getClassLoader().getResource("pic/xiezi.jpg").toString()
                ,50,50,false,false);
    }
}

class Follower extends Monster
{
    public Follower()
    {
        super();
        this.name = "小怪";
        this.image =  new Image(getClass().getClassLoader().getResource("pic/monster.jpg").toString()
                ,50,50,false,false);

    }
}