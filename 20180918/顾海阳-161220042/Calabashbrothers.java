import java.awt.*;
import java.util.Random;

enum hulubrother {
    one("老大", "红色", 0),
    two("老二", "橙色", 1),
    three("老三", "黄色", 2),
    four("老四", "绿色", 3),
    five("老五", "青色", 4),
    six("老六", "蓝色", 5),
    seven("老七", "紫色", 6);
    private final String name;
    private final String colour;
    public final int rank;
    hulubrother(String name,String colour,int rank)
    {
        this .name=name;
        this.colour=colour;
        this.rank=rank;
    }
   public void countnumber(){System.out.print(name);}
   public void countcolour(){System.out.print(colour);}
   public void report(int relocation,int location)
   {System.out.print(name+":"+relocation+"->"+location);}

}

public class Calabashbrothers{

    hulubrother []huluwa=hulubrother.values();
    private final static int TOTAL=7;
    private int []quene=new int [TOTAL];
    Calabashbrothers()
    {
        for (int i=0;i<TOTAL;i++)
            quene[i]=-1;
    }
    boolean inside(int n)
    {
        for(int i=0;i<TOTAL;i++)
        {
            if (quene[i]==n)
                return true;
        }
        return false;
    }
    void randomcalabash()
    {

        for (int i=0;i<TOTAL;i++)
            quene[i]=-1;
        for (int i=0;i<TOTAL;i++)
        {
            Random rand = new Random();
            int x=rand.nextInt(TOTAL);
            if (inside(x))
            {
                i--;
            }
            else
                quene[i]=x;
        }
        System.out.println("随机排序完成。");
    }
    void boublesort()
    {
        System.out.println("Bubble Sort:");
        for (int i=0;i<TOTAL-1;i++) {
            for (int j = 0; j < TOTAL - 1; j++) {
                if (quene[j] > quene[j + 1]) {
                    huluwa[j].report(j, j + 1);
                    System.out.println();
                    huluwa[j + 1].report(j + 1, j);
                    System.out.println();
                    int m = quene[j];
                    quene[j] = quene[j + 1];
                    quene[j + 1] = m;
                }
            }
        }
        for(int i=0;i<TOTAL;i++) {
            huluwa[quene[i]].countnumber();
        }
        System.out.println();
    }
    void binsort()
    {
        System.out.println("Bubble Sort:");
        for (int i = 0; i < TOTAL; i++) {
            int temp = quene[i];
            int a = 0;
            int b = i - 1;
            int middle = 0;
            while (a <= b) {
                middle = (a + b) / 2;
                if (temp < quene[middle]) {
                    b = middle - 1;
                } else {
                    a = middle + 1;
                }
            }
            for (int j = i - 1; j >= a; j--) {
                huluwa[quene[j]].report(j, j + 1);
                System.out.println();
                quene[j + 1] = quene[j];
            }
            if (a != i) {
                huluwa[temp].report(i, a);
                System.out.println();
                quene[a] = temp;
            }

        }
        for(int i=0;i<TOTAL;i++)
        {
            huluwa[quene[i]].countcolour();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Calabashbrothers chuluwa =new  Calabashbrothers();
        chuluwa.randomcalabash();
        chuluwa.boublesort();
        chuluwa.randomcalabash();
        chuluwa.binsort();

    }
}
