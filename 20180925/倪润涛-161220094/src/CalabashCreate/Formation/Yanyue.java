package CalabashCreate.Formation;

import CalabashCreate.beings.Goblin;
import CalabashCreate.beings.Snake;
import CalabashCreate.create.Create;

public class Yanyue extends Formation{
    public void goatYanyue()
    {
        Create yy = new Create();
        Snake snake = yy.snakeCreate();
        Goblin scorpoin = yy.goblinScorpoinCreate();
        Goblin goblin = yy.goblinCreate();
        for(int i=0;i<20;i++)
        {
            System.out.print(" ");
        }
        System.out.println(goblin.name+" "+scorpoin.name+" "+goblin.name);
        for(int i=0;i<20;i++)
        {
            System.out.print(" ");
        }
        System.out.println(goblin.name+" "+goblin.name+" "+goblin.name);
        for(int i=0;i<14;i++)
        {
            System.out.print(" ");
        }
        System.out.println(goblin.name+" "+goblin.name+" "+goblin.name+" "+goblin.name+" "+goblin.name);
        for(int i=0;i<11;i++)
        {
            System.out.print(" ");
        }
        System.out.println(goblin.name+" "+goblin.name+"             "+goblin.name+" "+goblin.name);
        for(int i=0;i<9;i++)
        {
            System.out.print(" ");
        }
        System.out.println(goblin.name+"                    "+goblin.name);
        for(int i=0;i<7;i++)
        {
            System.out.print(" ");
        }
        System.out.println(goblin.name+"                                "+goblin.name);
        for(int i=0;i<20;i++)
        {
            System.out.print(" ");
        }
        System.out.println(snake.name);
        //System.out.println("TODO_Yanyue");
    }
}
