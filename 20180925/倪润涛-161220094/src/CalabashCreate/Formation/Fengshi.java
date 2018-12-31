package CalabashCreate.Formation;

import CalabashCreate.beings.Goblin;
import CalabashCreate.beings.Snake;
import CalabashCreate.create.Create;

public class Fengshi extends Formation{
    public void goatFengshi(char [][]field)
    {
        Create fs = new Create();
        Snake snake = fs.snakeCreate();
        Goblin scorpoin = fs.goblinScorpoinCreate();
        Goblin goblin = fs.goblinCreate();
        for(int i=0;i<16;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[35m"+scorpoin.name +"\u001b[0m");
        for(int i=0;i<12;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m"+"  "+"\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<10;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m"+" "+"\u001b[33m"+goblin.name +"\u001b[0m"+" "+"\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<8;i++)
        {
            System.out.print(" ");
        }
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m"+"  "+"\u001b[33m"+goblin.name +"\u001b[0m"+"   "+"\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<16;i++)
            System.out.print(" ");
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<16;i++)
            System.out.print(" ");
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<16;i++)
            System.out.print(" ");
        System.out.println("\u001b[33m"+goblin.name +"\u001b[0m");
        for(int i=0;i<8;i++)
            System.out.print(" ");
        System.out.println(snake.name);
        field[7][9]='X';
        for(int i=10;i<15;i++)
            field[7][i]='M';
        field[6][10]='M';
        field[8][10]='M';
        field[5][11]='M';
        field[9][11]='M';
        field[4][12]='M';
        field[10][12]='M';
        field[3][14]='S';
    }
}
