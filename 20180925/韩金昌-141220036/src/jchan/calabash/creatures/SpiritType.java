package jchan.calabash.creatures;

public enum SpiritType{
    SCORPION,TOAD;
    public static SpiritType getType(int i){
        switch(i){
            case 0:
                return SpiritType.SCORPION;
            default:
                return SpiritType.TOAD;
        }
    }
}
