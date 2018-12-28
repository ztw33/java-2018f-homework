package backstage.creature.fighter.gourdboys;

public enum Attribute {
    FIRST(1,"大娃","红色",380,2300,80),
    SECOND(2,"二娃","橙色",330,2000,40),
    THIRD(3,"三娃","黄色",300,2000,70),
    FOURTH(4,"四娃","绿色",330,2000,40),
    FIFTH(5,"五娃","青色",330,2000,40),
    SIXTH(6,"六娃","蓝色",300,2000,60),
    SEVENTH(7,"七娃","紫色",330,2000,40);

    private int rank;
    private String name;
    private String color;

    protected int attack;
    protected int maxhp;
    protected int defense;

    Attribute(int rank, String name, String color, int attack, int maxhp, int defense){
        this.rank = rank;
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.maxhp = maxhp;
        this.defense = defense;
    }


    public String getName() { return name; }

    public int getAttack() {
        return attack;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getDefense() {
        return defense;
    }

}