public enum GourdDollColorEnum{
    RED(1, "红色"), ORINGE(2, "橙色"), YELLOW(3, "黄色"), GREEN(4, "绿色"), INDIGO(5, "青色"), BLUE(6, "蓝色"), PURPLE(7, "紫色");

    private final int GourdDollSeq;
    private final String GourdDollColor;

    private GourdDollColorEnum(int seq, String color){
        this.GourdDollSeq = seq;
        this.GourdDollColor = color;
    }

    public boolean isBigger(GourdDollColorEnum bro){
        if(this.GourdDollSeq < bro.GourdDollSeq)
            return true;
        else return false;
    }

    public int getSeq(){
        return this.GourdDollSeq;
    }

    public String getColor(){
        return this.GourdDollColor;
    }
}
