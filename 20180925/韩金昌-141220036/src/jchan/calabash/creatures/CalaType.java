package jchan.calabash.creatures;

public enum CalaType{
    STRONG,EYEEAR,HARD,FIRE,WATER,INVISIBLE,CALA,CALAS;
    public static CalaType getType(int i){
        switch(i){
            case 0:
                return CalaType.STRONG;
            case 1:
                return CalaType.EYEEAR;
            case 2:
                return CalaType.HARD;
            case 3:
                return CalaType.FIRE;
            case 4:
                return CalaType.WATER;
            case 5:
                return CalaType.INVISIBLE;
            case 6:
                return CalaType.CALA;
            default:
                return CalaType.STRONG;
        }
    }
}

