package MotherEarthPack.Scientific;

import MotherEarthPack.Entity.Battlefield;

public interface FriendlyForces {    // 友军接口

    int safeDistance = 2;            // 和友军保持一定的距离，避免太远

    void Locating(Coordinate troopCenter, Battlefield battlefield);   // 在战场上找到友军附近的位置安营扎寨
    void LoudlySupport();                                             // 加油呐喊

}
