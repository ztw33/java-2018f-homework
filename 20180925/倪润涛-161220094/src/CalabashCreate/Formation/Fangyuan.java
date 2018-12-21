package CalabashCreate.Formation;

import CalabashCreate.create.*;
import CalabashCreate.beings.*;

public class Fangyuan extends Formation{
    public void fYuan(char [][]field)
    {
        Create yuan = new Create();
        Snake snake = yuan.snakeCreate();
        Goblin scorpoin = yuan.goblinScorpoinCreate();
        Goblin goblin = yuan.goblinCreate();

        for(int i=0;i<16;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[35m"+scorpoin.name +"\u001b[0m"+"  ");
        for(int i=0;i<10;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m"+"      "+"\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<7;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m"+"            "+"\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<10;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m"+"      "+"\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<16;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m" + "\n");
        for(int i=0;i<16;i++)
        {
            System.out.print(" ");
        }
        System.out.println(snake.name);
        field[7][10]='X';
        field[7][14]='M';
        field[6][11]='M';
        field[8][11]='M';
        field[5][12]='M';
        field[9][12]='M';
        field[8][13]='M';
        field[6][13]='M';
        field[4][14]='S';
    }
}
