package CalabashCreate.Formation;

import CalabashCreate.beings.Goblin;
import CalabashCreate.beings.Snake;
import CalabashCreate.create.*;

public class Chonge extends Formation{
    public void goatChange()
    {
        //System.out.println("TODO_Change");
        Create cs = new Create();
        Snake snake = cs.snakeCreate();
        Goblin scorpoin = cs.goblinScorpoinCreate();
        Goblin goblin = cs.goblinCreate();
        System.out.println("    "+goblin.name+"  "+scorpoin.name+"  "+goblin.name);
        System.out.println("        "+goblin.name+"  "+goblin.name+"  "+goblin.name);
        System.out.println("                "+snake.name);
    }
}
