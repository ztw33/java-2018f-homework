# 面向葫芦娃编程

> 操作方法：
运行后根据提示选择提供的三种阵型，输入所选阵型，程序自动打印
战场上的生物清除，再次根据提示选择阵型，程序自动打印


### 自顶向下介绍如下


## Game 类

实现了对游戏中所涉及生物的创造，即初始化。



## Creature类

`Creature`类中封装了对于这个战场中所有生物所拥有的属性`name`和`location`。并写出了`toString()` 方法以及对`location`属性的`getter`和`setter`方法。
`Creature`类作为父类，有葫芦娃`CalabashBrothers`类，老爷爷`Grandpa`类，小喽啰`littleGuys`类，蛇精`SnakeSpirt`类以及蝎子精`ScorpionEssence`类继承于它。

对于每个生物，都重写了`toString()`的方法.
```
public String toString();//用来获得某生物的名字
   ```
对于以队列形式出现的生物 -- 葫芦娃和小喽啰，则另外添加了`CalabashBrothers cb[]`和`Creature[] lg`的实例变量和对队列的setter和getter方法。
另外葫芦娃类中有排序的两种方法
```
public void randomQueue() //随机排序
public void BubbleSort()  //冒泡排序
```

## Location类
```
 private int x;
 private int y;
 private Creature location_creature;
```
描述了某个生物的`x`和`y`坐标，以及某个`location`对应的`location_creature`

## BattleField类
```
private int row;
private int column;
public Location[][] arr; //建立Location类的二维数组用于存放creature
```
以上是`world`类的实例变量

```
public world(int row, int column){
    arr = new Location[row][column];
    for(int i=0; i<row; i++) {
        for (int j = 0; j < column; j++) {
              arr[i][j] = new Location(i,j);
              arr[i][j].setLocation_creature(new Space());
        }
     }        
}
 //BattleField类的构造函数，即构造一个行为row,列为column的BattleField
//将二维数组的每个位置的生物先放置为space
```


还有一些用于放置生物和队列以及对战场的清除和输出的方法
```
public void addCreature(Creature creature, Location location)

public void addQueue(Creature[] creature, Location startLocation, FormationImp formation)

public void clear(){

public void print(){
```


## Formation类

定义了一个`FormationImp`接口，定义了待实现方法`arrange()`
有六种不同的阵型实现了该接口
```
public void arrange(world battleField, Creature[] creature, Location location );
```


不足：
- 对于`CalabashBrothers`类和`LittleGuys`类可以共同继承一个队列类。
- 阵型实现可以对是否会超出边界进行判断
- 应该创建一个`Coorinator`类实现放置生物等行为，起到造物主的作用，更接近面向对象思想。
