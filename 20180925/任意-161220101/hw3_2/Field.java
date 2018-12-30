package renyi2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Field {
    int N;
    List<List<Creature>> field=new ArrayList<List<Creature>>();
    Field()
    {
        System.out.println("请输入战场的规格N（N>10）");
        Scanner in =new Scanner(System.in);
        N=in.nextInt();
        while(N<=10)
        {
            System.out.println("N的规格不符合标准，请重新输入");
            in =new Scanner(System.in);
            N=in.nextInt();
        }
        Creature one;
        for(int i=0;i<N;i++)
        {
            List<Creature> line=new ArrayList<Creature>();
            for(int j=0;j<N;j++)
            {
                line.add(one=new NullCreature(i,j));
            }
            field.add(line);
        }
    }
    public void setposition(int x,int y,Creature one)
    {
        field.get(x).set(y,one);
    }
    public void resetfield()
    {
        Creature one;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                field.get(i).set(j,one=new NullCreature(i,j));
        }
    }
    public void show()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                System.out.print(this.field.get(i).get(j).name+" ");
            System.out.print("\n");
        }
    }
}
