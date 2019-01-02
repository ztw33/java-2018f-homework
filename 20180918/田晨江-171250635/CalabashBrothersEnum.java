
public enum CalabashBrothersEnum{

    FIRST("老大","赤",1),
    SECOND("老二","橙",2),
    THIRD("老三","黄",3),
    FOURTH("老四","绿",4),
    FIFTH("老五","青",5),
    SIXTH("老六","蓝",6),
    SEVENTH("老七","紫",7);


    protected String name;
    protected String color;
    protected int order;

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


    CalabashBrothersEnum(String name, String color, int order){
        this.name = name;
        this.color = color;
        this.order = order;
    }

};