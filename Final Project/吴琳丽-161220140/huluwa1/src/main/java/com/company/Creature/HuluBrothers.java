package com.company.Creature;

import com.company.Creature.HuluBrother;

public class HuluBrothers {
    private Creature[] Hulu = new HuluBrother[7];//初始化构造七个葫芦娃
    public HuluBrothers() {
        for(int i =0; i<7; i++){
            Hulu[i]=new HuluBrother(i);
        }
    }//七个葫芦娃分别为Human枚举类型的1-7

    public Creature[] getHulu() {
        return Hulu;
    }

    /*void familyTellName() {
        for (int i = 0; i < 7; i++)
            Hulu[i].huluTellName();
    }//让整个队列的葫芦娃报名字
    void familyTellColor() {
        for (int i = 0; i < 7; i++)
            Hulu[i].huluTellColor();
    }//让整个队列的葫芦娃报颜色*/

}
