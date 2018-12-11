package MotherEarthPack.Scientific;

import java.util.Random;

public enum Formation
{
    Heyi,Yanxing,Henge,Changshe,Yulin,Fangyuan,Yanyue,Fengshi;


    public static Formation getARandomFormation() {
        Random random = new Random();
        switch (random.nextInt(8))
        {
            case 0:return Heyi;
            case 1:return Yanxing;
            case 2:return Henge;
            case 3:return Changshe;
            case 4:return Yulin;
            case 5:return Fangyuan;
            case 6:return Yanyue;
            case 7:return Fengshi;
            default:
                System.out.println("A fatal error has occred.\n");
        }
        return null;
    }
}