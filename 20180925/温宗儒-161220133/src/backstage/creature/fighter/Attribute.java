package backstage.creature.fighter;

public enum Attribute {
    FIRST(1,"大娃","红色"),
    SECOND(2,"二娃","橙色"),
    THIRD(3,"三娃","黄色"),
    FOURTH(4,"四娃","绿色"),
    FIFTH(5,"五娃","青色"),
    SIXTH(6,"六娃","蓝色"),
    SEVENTH(7,"七娃","紫色");

    private int rank;
    private String name;
    private String color;

    Attribute(int rank, String name, String color){
        this.rank = rank;
        this.name = name;
        this.color = color;
    }

    public int getRank() { return rank; }

    public String getName() { return name; }

    public String getColor() { return color; }
}