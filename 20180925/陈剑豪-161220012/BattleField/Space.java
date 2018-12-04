package BattleField;
import Creature.*;

public class Space {/**创建人：陈剑豪 创建时间：2018.10.2*/
    static public Existance[][] space;
    int sizeofspace;
    public Space(int n)
    {
        sizeofspace=n;
        space=new Existance[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {

                if(i==0||j==0||i==n-1||j==n-1)
                {
                    space[i][j]=Existance.bounder;
                }
                else
                space[i][j]=Existance.nothing;

            }
        }
    }

    public void putOnGrandparent(Grandparent grandparent,int row,int column)// 摆放爷爷
    {
        grandparent.standOnMap(row,column);
    }

    public void putOnSnakeMonster(SnakeMonster snakeMonster,int row,int column)// 摆放蛇精
    {
        snakeMonster.standOnMap(row,column);
    }

    public void remove()
    {
        for(int i=1;i<sizeofspace-1;i++)
        {
            for(int j=1;j<sizeofspace-1;j++)
            {
                space[i][j]=Existance.nothing;
            }
        }
        //System.out.println(Creature.list.size());

        for(int i=0;i<Creature.list.size();i++)
        {
            //System.out.println(Creature.list.get(i).name);
            Creature.list.get(i).init();
        }
    }

    public void display()
    {
        for(int i=0;i<sizeofspace;i++)
        {
            for(int j=0;j<sizeofspace;j++)
            {
                switch(space[i][j]) {
                    case bounder:
                        System.out.print("******");
                        break;
                    case nothing:
                        System.out.print("      ");
                        break;
                    case grandparent:
                        System.out.print("爷爷  ");
                        break;
                    case bigbrother:
                        System.out.print("老大  ");
                        break;
                    case secondbrother:
                        System.out.print("老二  ");
                        break;
                    case thirdbrother:
                        System.out.print("老三  ");
                        break;
                    case fourthbrother:
                        System.out.print("老四  ");
                        break;
                    case fifthbrother:
                        System.out.print("老五  ");
                        break;
                    case sixthbrother:
                        System.out.print("老六  ");
                        break;
                    case seventhbrother:
                        System.out.print("老七  ");
                        break;
                    case snake:
                        System.out.print("蛇精  ");
                        break;
                    case scorpion:
                        System.out.print("蝎子  ");
                        break;
                    case underlings:
                        System.out.print("喽啰  ");
                        break;
                }
            }
            System.out.println();
        }
    }
}
