
import java.awt.*;
import java.util.Random;

interface  cheer
{
   void cheerup();
}
class   creature {
    int NO;
    char tip;
    int px;
    int py;
    creature()
    {
        px=-1;
        py=-1;
    }
}

class Calabashbrothers extends creature {
    public hulubrother calabashbrother;

    enum hulubrother {
        one("老大", "红色"),
        two("老二", "橙色"),
        three("老三", "黄色"),
        four("老四", "绿色"),
        five("老五", "青色"),
        six("老六", "蓝色"),
        seven("老七", "紫色");
        private final String name;
        private final String colour;

        hulubrother(String name, String colour) {
            this.name = name;
            this.colour = colour;
        }
    }

    Calabashbrothers(hulubrother calabashbrother) {
        this.calabashbrother = calabashbrother;
        NO = calabashbrother.ordinal() + 1;
        tip = (char) (NO + '0');
    }
}
class Grandpa extends creature implements cheer{
    public  void cheerup()
    {return;}
    Grandpa()
    {
        NO=8;
        tip='G';
    }
}

class Scorpion extends creature{
    Scorpion()
    {
        NO=9;
        tip='S';
    }
}
class Snake extends creature{
    Snake()
    {
        NO=10;
        tip='s';
    }
}
class Followers extends creature{
    private static int begin=11;
    Followers()
    {
        NO=begin;
        begin++;
        tip='f';

    }
}

class Battleground
{
    char [][]ground;
    Battleground()
    {
        ground=new char[15][15];
        for(int i=0;i<ground.length;i++)
            for (int j=0;j<ground[i].length;j++)
                ground[i][j]=' ';
    }

    public char[][] getlocationinformation()
    {
        return ground;
    }
     public void  printbattleground(){
         for(int i=0;i<ground.length;i++) {
             for (int j = 0; j < ground[i].length; j++)
                 System.out.print(ground[i][j]);
             System.out.println();
         }
     }
     public  void clearbattleground() {
         for(int i=0;i<ground.length;i++)
             for (int j=0;j<ground[i].length;j++)
                 ground[i][j]=' ';
     }

}

class Formation {
    public void singlelinearry(creature []creatures,Battleground battleground)
    {
        int  distance=2;
        for(int i=0;i<7;i++)
            battleground.ground[4+i][2]=creatures[i].tip;
    }

    public void heyiarry(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][9]=creature[8].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[5][11]=creature[10].tip;
        battleground.getlocationinformation()[4][12]=creature[10].tip;
        battleground.getlocationinformation()[8][10]=creature[10].tip;
        battleground.getlocationinformation()[9][11]=creature[10].tip;
        battleground.getlocationinformation()[10][12]=creature[10].tip;

    }

    public  void yanxianarry(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][9]=creature[8].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[5][11]=creature[10].tip;
        battleground.getlocationinformation()[4][12]=creature[10].tip;
        battleground.getlocationinformation()[8][8]=creature[10].tip;
        battleground.getlocationinformation()[9][7]=creature[10].tip;
        battleground.getlocationinformation()[10][6]=creature[10].tip;
    }
    public  void hengearry(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][9]=creature[8].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[5][9]=creature[10].tip;
        battleground.getlocationinformation()[4][10]=creature[10].tip;
        battleground.getlocationinformation()[8][10]=creature[10].tip;
        battleground.getlocationinformation()[9][9]=creature[10].tip;
        battleground.getlocationinformation()[10][10]=creature[10].tip;
    }
    public  void yulinarray(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][9]=creature[8].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[7][10]=creature[10].tip;
        battleground.getlocationinformation()[8][10]=creature[10].tip;
        battleground.getlocationinformation()[5][11]=creature[10].tip;
        battleground.getlocationinformation()[6][11]=creature[10].tip;
        battleground.getlocationinformation()[7][11]=creature[10].tip;
        battleground.getlocationinformation()[8][11]=creature[10].tip;
        battleground.getlocationinformation()[9][11]=creature[10].tip;
        battleground.getlocationinformation()[7][12]=creature[10].tip;
    }

    public void fangtongarray(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][9]=creature[8].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[5][11]=creature[10].tip;
        battleground.getlocationinformation()[8][10]=creature[10].tip;
        battleground.getlocationinformation()[9][11]=creature[10].tip;
        battleground.getlocationinformation()[6][12]=creature[10].tip;
        battleground.getlocationinformation()[8][12]=creature[10].tip;
        battleground.getlocationinformation()[7][13]=creature[10].tip;
    }
    public  void yanyuearray(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][9]=creature[8].tip;
        battleground.getlocationinformation()[7][8]=creature[10].tip;
        battleground.getlocationinformation()[7][10]=creature[10].tip;
        battleground.getlocationinformation()[8][9]=creature[10].tip;
        battleground.getlocationinformation()[8][8]=creature[10].tip;
        battleground.getlocationinformation()[8][10]=creature[10].tip;
        battleground.getlocationinformation()[6][9]=creature[10].tip;
        battleground.getlocationinformation()[6][8]=creature[10].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[5][10]=creature[10].tip;
        battleground.getlocationinformation()[9][10]=creature[10].tip;
        battleground.getlocationinformation()[4][11]=creature[10].tip;
        battleground.getlocationinformation()[5][11]=creature[10].tip;
        battleground.getlocationinformation()[9][11]=creature[10].tip;
        battleground.getlocationinformation()[10][11]=creature[10].tip;
    }
    public  void fengshiarray(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][9]=creature[8].tip;
        for(int i=1;i<=3;i++)
        {
            battleground.getlocationinformation()[i+7][i+9]=creature[10].tip;
            battleground.getlocationinformation()[7-i][i+9]=creature[10].tip;
        }
        for(int i=1;i<=5;i++)
        {
            battleground.getlocationinformation()[7][i+9]=creature[10].tip;
        }
    }
    public  void setgrandpa(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][0]=creature[7].tip;
    }
    public  void setsnake(creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[7][14]=creature[9].tip;
    }

}
public class Calabashballlte {

    public static creature[]beings;
    public static int Maxcreature=40;
    public static void initialing()
    {
        beings=new creature[Maxcreature];
        beings[0]=new Calabashbrothers(Calabashbrothers.hulubrother.one);
        beings[1]=new Calabashbrothers(Calabashbrothers.hulubrother.two);
        beings[2]=new Calabashbrothers(Calabashbrothers.hulubrother.three);
        beings[3]=new Calabashbrothers(Calabashbrothers.hulubrother.four);
        beings[4]=new Calabashbrothers(Calabashbrothers.hulubrother.five);
        beings[5]=new Calabashbrothers(Calabashbrothers.hulubrother.six);
        beings[6]=new Calabashbrothers(Calabashbrothers.hulubrother.seven);
        beings[7]=new Grandpa();
        beings[8]=new Scorpion();
        beings[9]=new Snake();
        for(int i=10;i<Maxcreature;i++)
        beings[i]=new Followers();
    }

    public static void main(String[] args) {
        initialing();
        Scorpion scorpion=new Scorpion();
        Battleground battleground=new Battleground();
        Formation formation=new Formation();
        formation.singlelinearry(beings,battleground);
        //formation.heyiarry(beings,battleground);
        //formation.yanyuearray(beings,battleground);
        //formation.fengshiarray(beings,battleground);
        formation.hengearry(beings,battleground);
        formation.setgrandpa(beings,battleground);
        formation.setsnake(beings,battleground);
        battleground.printbattleground();
    }
}
