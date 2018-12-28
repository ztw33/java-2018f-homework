package com.company.Creature;
import com.company.Creature.HuluBrother;

import java.util.Random;

public class Sort{
    public static void BubbleSort(HuluBrother[] Hulu) {//冒泡排序根据名字
        for (int p = 0; p <Hulu.length - 1; p++)
            for (int q = 0; q < Hulu.length - p - 1; q++) {
                if (Hulu[q].TellOrdinal()> Hulu[q + 1].TellOrdinal()) {
                    HuluBrother temp = Hulu[q];
                    Hulu[q] = Hulu[q + 1];
                    Hulu[q + 1] = temp;
                    //System.out.println(Hulu[q+1].name + ": " + q + "->" + (q + 1));
                   // System.out.println(Hulu[q].name + ": " + (q+1) + "->" + q );
                }
            }
    }
    static void BinarySort(HuluBrother[] Hulu) {//二分排序根据颜色
        int i, j;
        int high, low, mid;
        HuluBrother temp;
        for (i = 1; i < Hulu.length; i++) {
            low = 0;
            high = i - 1;
            temp = Hulu[i];
            while (low <= high) {
                mid = (low + high) >> 1;
                if (temp.color.ordinal() < Hulu[mid].color.ordinal())
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (j = i - 1; j >= low; j--){
                //System.out.println(temp.name+ ": " + j + "->" + (j+1));
                Hulu[j + 1] = Hulu[j];
            }
            if(i != low)
               // System.out.println(temp.name+ ": " + i + "->" + low);
            Hulu[low] = temp;
        }
    }
    public static void RandomChange(HuluBrother[] Hulu){//随机排列
        Random random = new Random();
        for(int i=0;i<7;i++){
            int p = random.nextInt(i+1);
            HuluBrother tmp = Hulu[i];
            Hulu[i] = Hulu[p];
            Hulu[p] = tmp;
        }
    }
}