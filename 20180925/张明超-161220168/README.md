# 使用的面向对象概念
##1.继承
蛇精，爷爷，葫芦娃，蝎子精，小喽啰都继承自生物类
##2.动态绑定实现的多态
蛇精，爷爷，葫芦娃，蝎子精，小喽啰分别重写creatrue中的方法，在遍历Battlefield打印对应位置信息的时候，动态绑定creatrue子类中重写的方法
#设计理念
##思想
有多种生物，有两方的布阵人员，有战场\
1.不同生物都是生物\
2.两方分别生成需要布阵的人员\
3.布阵人员和战场的关系由class Formation来协调\
##类型设计
1.所有生物继承自class Creatrue，Creatrue中包含每个生物的信息，目前仅有位置信息（后续可能会有血量等）。\
```java
public class Creature {
    // 报名字
    public void toldCreature();
    // 改变位置信息
    public void move(int x ,int y);
}
```
2.class Enemy包括蝎子精和小喽啰两种 class Calabashbrother 包括所有葫芦娃种类(使用Inner class，在内部定义一个enum的类，记录所有种类)，class Snake和class Grandfather 单独对待，不需要布阵。\
```java
class Enemy extends Creature{
    // 枚举类所有enemy类型 ，不包括蛇精
    enum EnemyType{};
    // 设置怪物类型
    public void setType(int index);
    @Override
    // 重写Creature中的报生物名
    public void toldCreature();
}
//CalabashBrother与上面类似
class CalabashBrother extends Creature{
    
};

class Grandfather extends Creature{
    // 获取名字
    public String getName();
    @Override
    // 重写Creature中的报生物名
    public void toldCreature();
}
//Snake和上面类似
class Snake extends Creature{
    
};
```
3.class CalabashGroup 和EnemyGroup 分别包括了双方的需要布阵的人员\
```java
class EnemyGroup {
    // 构造需要布阵的enemy人员
    public EnemyGroup(){
        group = new Enemy[8];
        for(int i = 0; i < group.length; i++){
            group[i] = new Enemy(1);
        }
        group[group.length/2].setType(0);
    }
    // 获取需要布阵的人员
    public Creature[] getFormationCreatrue(){
        return (Creature[])group;
    }
    private Enemy[] group;
}
// CalabashGroup与上面类似
class CalabashGroup{
    
};
```
4.class Battlefield 是场地储存了每个位置上的内容，即Creatrue类型的引用，如果没有则为null。\
```java
public class Battlefield {
    // 构造一个20*8的战场
    public Battlefield();
    // 设置对应区域所站的生物
    public void setBattlefield(int x, Creature toStandOn);
    public void setBattlefield(int x, int y, Creature toStandOn);
    // 打印战场上的情况
    public void printField();
    // 获取战场的高和宽
    public int getHeight();
    public int getWidth();
}
```
5.class Formation 用于将需要布阵的人员从之前的位置移除，放在阵法所指定的位置上，修改生物的位置坐标\
```java
public class Formation {
    // 所有阵法类型
    enum FormationType{};
    // 将要布阵的生物从战场上拿走然后放下
    public void formationCreatrue(Battlefield field, int index, Creature[] list, int category);
    // 存储阵法的数组
    int[][] Formationlist;
}
```
#好处
1.使用多态，精简代码\
2.面向对象，易于理解\