package com.company.Creature;

import com.company.Creature.HuluBrother;

public class HuluBrothers {
    public HuluBrother[] Hulu = new HuluBrother[7];//初始化构造七个葫芦娃
    public HuluBrothers() {
        for(int i =0; i<7; i++){
            Hulu[i]=new HuluBrother(i);
        }
    }//七个葫芦娃分别为Human枚举类型的1-7

    void FamilyTellName() {
        for (int i = 0; i < 7; i++)
            Hulu[i].HuluTellName();
    }//让整个队列的葫芦娃报名字
    void FamilyTellColor() {
        for (int i = 0; i < 7; i++)
            Hulu[i].HuluTellColor();
    }//让整个队列的葫芦娃报颜色

}
