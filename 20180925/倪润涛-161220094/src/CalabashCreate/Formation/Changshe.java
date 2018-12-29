package CalabashCreate.Formation;

import CalabashCreate.create.*;
import CalabashCreate.beings.*;

public class Changshe extends Formation{
    public void sheepChangshe(char [][]field)
    {
        Create cs= new Create();
        Calabash []brothers = cs.calabashCreate();
        Grandpa grandpa = cs.grandpaCreate();
        for(int i=0;i<10;i++)
        {
            System.out.print(" ");
        }
        System.out.println(grandpa.name);
        System.out.print("\033[91;4m" + brothers[0].name + "\033[0m"+"  ");
        System.out.print("\033[33;4m" + brothers[1].name + "\033[0m"+"  ");
        System.out.print("\033[93;4m" + brothers[2].name + "\033[0m"+"  ");
        System.out.print("\033[92;4m" + brothers[3].name + "\033[0m"+"  ");
        System.out.print("\033[94;4m" + brothers[4].name + "\033[0m"+"  ");
        System.out.print("\033[96;4m" + brothers[5].name + "\033[0m"+"  ");
        System.out.print("\033[95;4m" + brothers[6].name + "\033[0m");
        System.out.println();
        field[7][0] = 'G';
        for(int i=0;i<7;i++)
            field[i+4][2]='B';
    }

    public void goatChangshe(char [][]field)
    {
        Create cs = new Create();
        Snake snake = cs.snakeCreate();
        Goblin scorpoin = cs.goblinScorpoinCreate();
        Goblin goblin = cs.goblinCreate();
        for(int i=0;i<7;i++)
        {
            if(i==3)
            {
                System.out.print("\u001b[35m"+scorpoin.name +"\u001b[0m"+"  ");
            }
            else
                System.out.print(goblin.name+"  ");
        }
        for(int i=0;i<10;i++)
        {
            System.out.print(" ");
        }
        System.out.print(snake.name);
        field[7][14] = 'S';
        field[7][12] = 'X';
        for(int i=0;i<7;i++) {
            if(i!=3)
                field[i + 4][12] = 'M';
        }
    }
}
