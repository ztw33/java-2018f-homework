package creature;

public enum CBEnum {
    First("大娃",'1',"红色"),
    Second("二娃",'2',"橙色"),
    Third("三娃",'3',"黄色"),
    Fourth("四娃",'4',"绿色"),
    Fifth("五娃",'5',"青色"),
    Sixth("六娃",'6',"蓝色"),
    Seventh("七娃",'7',"紫色");

    private String name;
    private String color;
    private char symbol;

    CBEnum(String name,char symbol, String color){
        this.name=name;
        this.symbol=symbol;
        this.color=color;
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public char getSymbol(){
        return symbol;
    }

}
