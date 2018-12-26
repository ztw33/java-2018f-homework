package CalashBro;
import javafx.scene.canvas.Canvas;

import java.util.*;
import java.util.Random;

//对峙
public class Confront {
    private CalabashBrother []Huluwas;
    private Grandfather grandfather;
    private Snake snake;
    private Scorpion scorpion;
    private Follower []follower;
    private Battlefield ground;
    private Formation form;

    public Confront(){
        ground = new Battlefield(10,20); //创造一个10行20列的战场
        form = new Formation();
        //葫芦娃
        Huluwas = new CalabashBrother[7];
        for(int i  = 0;i<7;i++)
        {
            Huluwas[i] = new CalabashBrother(i,0,0);
        }
        //爷爷
        grandfather = new Grandfather();
        //蛇精
        snake = new Snake();
        //蝎子精
        scorpion = new Scorpion();
        //小怪
        follower = new Follower[8];
        for(int i = 0; i < 8;i++)
        {
            follower[i] = new Follower();
        }
        //初始化完毕
    }
    public static void main(String[]args)
    {
        for(FormationName x:FormationName.values()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //初始化放置葫芦娃
    public void initHuluwa( ) {
        Random rand =new Random();
        for(int i = 0; i  < 7;i++) {
            int k = rand.nextInt(7);
            CalabashBrother temp = Huluwas[k];
            Huluwas[k] = Huluwas[i];
            Huluwas[i] = temp;
        }
        //将葫芦娃放置在战场上
        for(int i = 0; i <7;i++)
        {
            ground.putTheCre(Huluwas[i],i+1,5);
        }
    }
    //初始化爷爷
     public void initGrandfather( )
     {
         ground.putTheCre(grandfather,5,0);
     }
     //初始化蛇精
     public void initMonster( )
     {
         ground.putTheCre(snake,5,19);
     }
     //排序葫芦娃
    public void sortThehuluwa( ) {
        for(int i = 6; i >= 0;i--)
        {
            for(int j = 0; j < i;j++)
            {
                if(Huluwas[j].getPro() > Huluwas[j+1].getPro())
                {
                    CalabashBrother temp = Huluwas[j];
                    Huluwas[j] = Huluwas[j+1];
                    Huluwas[j+1] = temp;
                }
            }
        }
        for(int i = 0; i<7;i++)
        {
            ground.movTheCre(Huluwas[i],i+1,5);
        }
    }
    //改变阵型
    public void makeChangeofMonster(FormationName name) {
        int index = name.ordinal();
        form.changeFormation(index,scorpion,follower,ground);
    }
    //打印
    public void printThefield(Canvas canvas) {
        for(int i = 0; i< 10;i++)
        {
            for(int j = 0; j < 20;j++)
            {
                ground.showThecreature(i,j,canvas);
            }
            System.out.println();
        }
    }
    //public
}
