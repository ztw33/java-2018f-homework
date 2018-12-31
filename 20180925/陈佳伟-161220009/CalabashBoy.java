package Homework.CalabashBrothers_2;

public enum CalabashBoy {

    RED(1,"大娃","红色"), ORANGE(2,"二娃","橙色"),YELLOW(3,"三娃","黄色"),GREEN(4,"四娃","绿色"),
    CYAN(5,"五娃","青色"),BLUE(6,"六娃","蓝色"),PURPLE(7,"七娃","紫色");

    public final int rank;
    public final String name;
    public final String color;

    CalabashBoy(int rank, String name, String color) {
        this.rank  = rank;
        this.name = name;
        this.color = color;
    }

    public String tellname(){
        System.out.println(name);
        return name;
    }

    public String tellcolor(){
        System.out.println(color);
        return color;
    }

    public boolean compareWith(CalabashBoy T){
        return T.rank < this.rank;
    }

}
