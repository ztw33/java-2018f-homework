package CalabashCreate;

import CalabashCreate.beings.*;
import CalabashCreate.create.*;
import CalabashCreate.Formation.*;

public class Main {
    public static void memSet(char [][]field)
    {
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
                field[i][j]='.';
    }

    public static void main(String[] args) {
        char [][]field;
        field = new char[15][15];
        memSet(field);
        System.out.println("第一种对峙阵型：");
        Changshe cs = new Changshe();
        cs.sheepChangshe(field);
        System.out.println("\n");
        Fangyuan fy = new Fangyuan();
        fy.fYuan(field);
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
        Battlefield bf = new Battlefield(50);
        bf.showBattlefield(field);
        memSet(field);

        System.out.println("第二种对峙阵型：");
        cs.sheepChangshe(field);
        System.out.println("\n");
        Fengshi fs = new Fengshi();
        fs.goatFengshi(field);
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
        Battlefield bf1 = new Battlefield(50);
        bf1.showBattlefield(field);
        memSet(field);
    }
}
