package com.company;
import java.util.Random;

enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, VIOLET
}

enum Human {
    ONE("老大", com.company.Color.RED), TWO("老二", com.company.Color.ORANGE), THREE("老三", com.company.Color.YELLOW), FOUR("老四", com.company.Color.GREEN),
    FIVE("老五", com.company.Color.CYAN), SIX("老六", com.company.Color.BLUE), SEVEN("老七", com.company.Color.VIOLET);
    private String name;
    private com.company.Color color;
    private Human(String name, com.company.Color c) {
        this.name = name;
        this.color = c;
    }
    public static String getName(int index) {
        for (com.company.Human c : com.company.Human.values()) {
            if (c.ordinal() == index) {
                return c.name;
            }
        }
        return null;
    }
    public static com.company.Color getColor(int index) {
        for (com.company.Human c : com.company.Human.values()) {
            if (c.ordinal()== index) {
                return c.color;
            }
        }
        return null;
    }
    public static void TellColor(int index){
        for (com.company.Human c : com.company.Human.values()) {
            if (c.ordinal()== index) {
                System.out.println(c.getColor(index));
            }
        }
    }

    public static void TellName(int index){
        for (com.company.Human c : com.company.Human.values()) {
            if (c.ordinal()== index) {
                System.out.println(c.getName(index));
            }
        }
    }
}

class HuluBrothers {
    com.company.Human[] Hulu = new com.company.Human[7];
    HuluBrothers() {
        Hulu[0] = com.company.Human.ONE;
        Hulu[1] = com.company.Human.TWO;
        Hulu[2] = com.company.Human.THREE;
        Hulu[3] = com.company.Human.FOUR;
        Hulu[4] = com.company.Human.FIVE;
        Hulu[5] = com.company.Human.SIX;
        Hulu[6] = com.company.Human.SEVEN;
    }
    void FamilyTellName() {
        for (int i = 0; i < 7; i++)
            Hulu[i].TellName(Hulu[i].ordinal());
    }

    void FamilyTellColor() {
        for (int i = 0; i < 7; i++)
            Hulu[i].TellColor(Hulu[i].ordinal());
    }

}

class Sort{
    void BubbleSort(com.company.Human[] Hulu) {
        for (int p = 0; p <Hulu.length - 1; p++)
            for (int q = 0; q < Hulu.length - p - 1; q++) {
                if (Hulu[q].ordinal()> Hulu[q + 1].ordinal()) {
                    com.company.Human temp = Hulu[q];
                    Hulu[q] = Hulu[q + 1];
                    Hulu[q + 1] = temp;
                    System.out.println(Hulu[q+1].getName(Hulu[q+1].ordinal() ) + ": " + q + "->" + (q + 1));
                    System.out.println(Hulu[q].getName(Hulu[q].ordinal() ) + ": " + (q+1) + "->" + q );
                }
            }
    }
    void BinarySort(com.company.Human[] Hulu) {
        int i, j;
        int high, low, mid;
        com.company.Human temp;
        for (i = 1; i < Hulu.length; i++) {
            low = 0;
            high = i - 1;
            temp = Hulu[i];
            while (low <= high) {
                mid = (low + high) >> 1;
                if (temp.getColor(temp.ordinal()).ordinal() < Hulu[mid].getColor(Hulu[mid].ordinal()).ordinal())
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (j = i - 1; j >= low; j--){
                System.out.println(temp.getName(Hulu[j].ordinal())+ ": " + j + "->" + (j+1));
                Hulu[j + 1] = Hulu[j];
            }
            if(i != low)
                System.out.println(temp.getName(temp.ordinal())+ ": " + i + "->" + low);
            Hulu[low] = temp;
        }
    }
    void RandomChange(com.company.Human[] Hulu){
        Random random = new Random();
        for(int i=0;i<7;i++){
            int p = random.nextInt(i+1);
            com.company.Human tmp = Hulu[i];
            Hulu[i] = Hulu[p];
            Hulu[p] = tmp;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        com.company.HuluBrothers HuluFamily = new com.company.HuluBrothers();
        com.company.Sort sort = new com.company.Sort();
        sort.RandomChange(HuluFamily.Hulu);
        System.out.println("第一次随机排列后报数：");
        HuluFamily.FamilyTellName();
        System.out.println("根据名字进行冒泡排序：");
        sort.BubbleSort(HuluFamily.Hulu);
        System.out.println("第一次排序后报名字：");
        HuluFamily.FamilyTellName();
        sort.RandomChange(HuluFamily.Hulu);
        System.out.println("第二次随机排列后报数：");
        HuluFamily.FamilyTellName();
        System.out.println("根据颜色进行二分法排序：");
        sort.BinarySort(HuluFamily.Hulu);
        System.out.println("第二次排序后报颜色：");
        HuluFamily.FamilyTellColor();
    }
}
