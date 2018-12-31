package com.company.Creature;

enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, VIOLET
}//将七种颜色定义为枚举类型
enum Human {
    ONE("老大", Color.RED), TWO("老二", Color.ORANGE), THREE("老三", Color.YELLOW), FOUR("老四", Color.GREEN),
    FIVE("老五", Color.CYAN), SIX("老六", Color.BLUE), SEVEN("老七", Color.VIOLET);//将七个葫芦娃定义为枚举类型
    private String name;
    private Color color;
    private Human(String name, Color c) {
        this.name = name;
        this.color = c;
    }//构造函数给每个葫芦娃特定的名字和颜色
    public String getName() {
        return name;
    }//得到名字
    public Color getColor() {
        return color;
    }//得到颜色

}

