package SortForCalabash;/*
 *   @author: "Maplewings"
 *   @e-mail: maplewings1101@gmail.com
 *   @date: 18-9-21
 */

import java.util.Random;

enum Cala {
    Red(0, "老大","红色"), Orange(1, "老二","绿色"), Yellow(2, "老三","黄色"),Green(3,"老四","绿色"),Cyan(4,"老五","青色"),Blue(5,"老六","蓝色"),Violet(6,"老七","紫色");
    int symbol;
    private String name;
    private String color;
    private Cala(int symbol, String name, String color) {
        this.symbol = symbol;
        this.name = name;
        this.color = color;
    }//这里是葫芦的构造函数

    void outName() {
        System.out.print(this.name+" ");
    }//报出葫芦的名字

    void outColor()
    {
        System.out.print(this.color+" ");
    }//报出葫芦的颜色

    void outSymbol() {
        System.out.print(this.symbol+" ");
    }//报出葫芦的排序序号

    void changePos(int goal) {
        //System.out.print(this.name + "：" + this.symbol + "->" + goal+" ");
        System.out.println(this.name + "：" + this.symbol + "->" + goal+" ");
        this.symbol = goal;
    }//葫芦娃向目标地址移动并报数
}

class Grandfather {
    String name;
    static int[] list = new int[7];//一个数组记录葫芦们的顺序,list[i]的值表示不同的葫芦

    Grandfather(String name, Cala[] boys) {
        this.name = name;
        for (int i = 0; i < 7; i++)//让爷爷知道葫芦的序列
            list[boys[i].symbol] = boys[i].ordinal();//根据葫芦的位置，存入记录序列中
    }

    void speakNameBySymbol(Cala[] boys) {
        for (int i = 0; i < 7; i++) {
            boys[list[i]].outName();
        }
        System.out.println();
    }//让葫芦娃们按照记录好的顺序报名字

    void speakColorBySymbol(Cala[] boys) {
        for (int i = 0; i < 7; i++) {
            boys[list[i]].outColor();
        }
        System.out.println();
    }//让葫芦娃们按照记录好的顺序报颜色

    void speakSymbol(Cala[] boys) {
        for (int i = 0; i < 7; i++)
            boys[i].outSymbol();
        System.out.println();
    }//让葫芦娃们报自己的序号

    void randomSort(Cala[] boys) {
        Random r1 = new Random();
        boolean[] note = new boolean[7];//利用boolean数组进行类hash算法分配桶
        for (int i = 0; i < 7; i++) {
            boys[i].symbol = r1.nextInt(7);//生成一个[0,6]的随机数区间
            while (note[boys[i].symbol] == true)
                boys[i].symbol = (boys[i].symbol + 1) % 7;
            note[boys[i].symbol] = true;
            list[boys[i].symbol] = boys[i].ordinal();//根据葫芦的位置，存入记录序列中
        }
    }//随机生成一段序列

    void swapPos(Cala[] boys, int i, int j) {
        int temp = list[i];//记录i位置的葫芦
        boys[list[j]].changePos(i);//j位置的葫芦移动到i
        list[i] = list[j];//i位置记录移动后的葫芦
        boys[temp].changePos(j);//原来i位置的葫芦移动到j
        list[j] = temp;
    }//交换list中存储的两个位置的葫芦

    void bubbleSort(Cala[] boys) {
        for (int i = 0; i < 7; i++)
            for (int j = 6; j > i; j--)
                if (list[j - 1] > list[j]) {
                    swapPos(boys, j - 1, j);
                }
    }//从老大到老七进行冒泡排序(从小到大)

    void bisSort(Cala[] boys) {
        int left = 0, right = 6;
        int temp = 0;
        int low = 0, high = 0, middle = 0;
        for (int i = 1; i <= right; i++) {
            temp = list[i];
            low = left;
            high = i - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (temp < list[middle]) {
                    high = middle - 1;
                } else low = middle + 1;

            }
            for (int k = i - 1; k >= low; k--) {
                boys[list[k]].changePos(k + 1);
                list[k + 1] = list[k];
            }
            if (temp != list[low]) {
                boys[temp].changePos(low);
                list[low] = temp;
            }
        }
    }//从老大到老七进行二分排序(从小到大)
}

public class SortForCalabash {
    public static void main(String[] args) {
        Cala[] boys = Cala.values();//创建一串葫芦
        Grandfather yeye = new Grandfather("yeye", boys);//创建一个爷爷
        System.out.println(yeye.name);
        System.out.println("开始冒泡排序");
        System.out.print("随机排序得到：");
        yeye.randomSort(boys);
        yeye.speakNameBySymbol(boys);
        yeye.bubbleSort(boys);
        System.out.print("排序结果为：");
        yeye.speakNameBySymbol(boys);
        System.out.println();
        System.out.println("开始二分排序");
        System.out.print("随机排序得到：");
        yeye.randomSort(boys);
        yeye.speakNameBySymbol(boys);
        yeye.bisSort(boys);
        System.out.print("排序结果为：");
        yeye.speakColorBySymbol(boys);
    }
}