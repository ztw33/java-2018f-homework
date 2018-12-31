# work3设计思路：

面向对象的概念与机制

## 抽象、封装与继承：

生物共两类：守序阵营与混乱阵营。守序阵营包括葫芦娃和爷爷；混乱阵营包括蝎精、喽啰和蛇精。用基类`Creature`表示生物，子类`Monster`表示混乱阵营，子类`HuLuWa`表示葫芦娃。

葫芦娃是7个个体，设`HuLuBros`类管理葫芦娃，实现排序、乱序及站队等方法。怪物是不定个数的个体，因此模糊其个体概念，设`Monsters`类管理怪物，实现列阵方法。

为实现战场，设计`Board`类，初始化为M*N的格子，上面可以防止`Creature`类的对象。

## 消息传递机制：

葫芦娃的站队方法实现在`HuLuBros`类中，怪物的站队方法实现在`Monsters`类中，`Board`类无从得知站队方式，设计`Block`类为消息传递的单元，`Board`向阵营对象传入首领位置，阵营对象向`Board`对象返回`Block`类型数组，标志每一个`Creature`站立的位置。

## 具体实现：

基类`Creature`：

```java
public class Creature {
    private  CreatureType type;
    private String name;
    public Creature(CreatureType type,String name);
    public CreatureType gettype();
    public String getname();
}
```



管理葫芦娃的`HuLuBros`类：

```java
public class HuLuBros {
    private List<HuLuWa> bros;
    HuLuBros();
    public void initialize();
    public void shuffle();
    public void sort();
    public HuLuWa getbro(int i);
    public Block[] HuLustand(int x,int y);
}

```



管理怪物的`Monsters`类：

```java
public class Monsters {
    private List<Monster> mons;
    Monsters(){mons = new ArrayList<Monster>();}
    public Block[] map1(int x,int y,int z);
    public Block[] map2(int x,int y , int z);
    public Block[] map3(int x , int y, int z);
    public Block[] map4(int x , int y, int z);
    public Block[] map5(int x , int y, int z);
}

```



显式表现的战场`Board`类：

```java
public class Board {
    private Object[][] board;
    private static final int Rows = 40;
    private static final int Lines = 11;
    public Board();
    public void clear();
    public void setmap1(HuLuBros hulubros,Monsters mons);
    public void setmap2(HuLuBros hulubros,Monsters mons);
    public void setmap3(HuLuBros hulubros,Monsters mons);
    public void setmap4(HuLuBros hulubros,Monsters mons);
    public void setmap5(HuLuBros hulubros,Monsters mons);
    public void printmap();
}

```

