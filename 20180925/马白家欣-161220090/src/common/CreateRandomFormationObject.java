package com.homework3.common;

import com.homework3.formation.*;

import java.util.Random;

/**
 * @Description 创建随机阵型
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class CreateRandomFormationObject {

    static private Random rand = new Random();
    static public int TOTAL_FORMATION_COUNT = 8;
    static private Formation[] formationArray = {new HeYi(), new YanXing(), new ChongE(), new ChangShe(),
            new YuLin(), new FangYuan(), new YanYue(), new FengShi()};

    static public Formation createRandomFormationObject() {
        int formationNumber;
        formationNumber = rand.nextInt(TOTAL_FORMATION_COUNT);
        return formationArray[formationNumber];
    }
}
