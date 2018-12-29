package MotherEarthPack.Scientific;

import MotherEarthPack.Entity.Battlefield;

public interface Camp {

    void setCenter(Battlefield battlefield);               // 设置队伍的中心
    void setFormation(Formation formation);                // 设置阵型
    Formation getFormation();                              // 获知队形
    void PlaceTheTroops(Battlefield battlefield);          // 放置队伍
    void FriendlyForcesComeOn(Battlefield battlefield);    // 友军登场
    void LoudlySupport();                                  // 友军加油助威

}
