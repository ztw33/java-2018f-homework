package huluwa;
import java.util.*;
import java.util.Random;

//对峙
public class Confront {
    private CalabashBrother []Huluwas;
    private Grandfather grandfather;
    private Snake snake;
    private Scorpion scorpion;
    private Follower []follower;
    Confront(){
        //对峙的类含有下列的生物所以进行初始化
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
        Confront battle = new Confront();
        Battlefield ground = new Battlefield(10,20); //创造一个10行20列的战场
        Formation form = new Formation();
        Jfshow jf = new Jfshow();
        battle.initHuluwa(ground); //放置葫芦娃
        battle.initGrandfather(ground);
        battle.initMonster(ground);
        battle.printThefield(ground,jf);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       System.out.println("排序葫芦娃");
        battle.sortThehuluwa(ground);
        battle.printThefield(ground,jf);

        for(FormationName x:FormationName.values()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            battle.makeChangeofMonster(x,form,ground);
            battle.printThefield(ground,jf);
        }
    }


    //初始化放置葫芦娃
    public void initHuluwa(Battlefield ground)
    {
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
        for(int i = 0;i <7;i++)
        {
            Huluwas[i].callTheposition();
        }
    }
    //初始化爷爷
     public void initGrandfather(Battlefield ground)
     {
         ground.putTheCre(grandfather,5,0);
     }
     //初始化蛇精
     public void initMonster(Battlefield ground)
     {
         ground.putTheCre(snake,5,19);
     }
     //排序葫芦娃
    public void sortThehuluwa(Battlefield ground)
    {
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
    public void makeChangeofMonster(FormationName name,Formation form,Battlefield ground)
    {
        int index = name.ordinal();
        form.changeFormation(index,scorpion,follower,ground);
    }
    //打印
    public void printThefield(Battlefield ground,Jfshow jf)
    {
        for(int i = 0; i< 10;i++)
        {
            for(int j = 0; j < 20;j++)
            {
                ground.showThecreature(i,j,jf);
            }
            System.out.println();
        }
        jf.showJf();
    }
}
