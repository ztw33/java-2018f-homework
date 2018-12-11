package MotherEarthPack;

import HuluPack.HuluCamp;
import MonsterPack.MonsterCamp;
import MotherEarthPack.Entity.Battlefield;
import MotherEarthPack.Scientific.Formation;


public class Director
{
    private MonsterCamp monsterCamp;
    private HuluCamp huluCamp;
    private Battlefield battlefield;

    private void CreationOfTheWorld() {
        monsterCamp = new MonsterCamp();
        monsterCamp.recruitGoblins(18);
        huluCamp = new HuluCamp();
        battlefield = new Battlefield(50);
    }

    private void CurtainCall() {
        monsterCamp = null;
        huluCamp = null;
        battlefield = null;
    }

    public void HaveAShow()
    {
        CreationOfTheWorld();                                             // 开天辟地，产生妖怪阵营，葫芦娃阵营，战场
        huluCamp.setFormation(Formation.Changshe);                        // 葫芦娃将自己的阵型设置为长蛇
        do {
            monsterCamp.setFormation(Formation.getARandomFormation());    // 妖怪将自己的阵型任意设置为非长蛇的一个阵型
        }while(monsterCamp.getFormation() == Formation.Changshe);
        huluCamp.setCenter(battlefield);                                  // 葫芦娃阵营找好自己在战场上的大致布营位置
        huluCamp.PlaceTheTroops(battlefield);                             // 葫芦娃阵营在战场上布阵
        huluCamp.FriendlyForcesComeOn(battlefield);                       // 爷爷登场
        monsterCamp.setCenter(battlefield);                               // 妖怪阵营找好自己在战场上的大致布营位置
        monsterCamp.PlaceTheTroops(battlefield);                          // 妖怪在战场上布阵
        monsterCamp.FriendlyForcesComeOn(battlefield);                    // 蛇精登场
        battlefield.ShowBattleField();                                    // 显示对峙局面
        huluCamp.LoudlySupport();                                         // 爷爷加油助威
        monsterCamp.LoudlySupport();                                      // 蛇精加油助威

        CurtainCall();                                                    // 演出完毕，谢幕

    }

    public static void main(String[] args) {
        Director director = new Director();        // 导演（制片人）登场

        for (int i = 0; i < 1; i++) {              // 进行两场表演
            director.HaveAShow();
        }

    }
}
