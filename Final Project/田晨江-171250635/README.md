# 面向葫芦娃编程

> 操作方法：

运行后进入开始界面，用鼠标点击任意位置后进入战场。点下键盘中的空格键开始战斗，最后按下^E清理战场。

### 自顶向下介绍如下

## Main 类

`Main`是整个程序的入口，继承了`Application`类，开始运行后进入开始界面的页面。

## WelcomePageController 类

采用了css文件定义背景，并做JavaFX做了一个小型动画。进入开始界面后创建世界的总控制者`Controller`对象，由它来进行世界的布置和运转.。

## Controller 类

一方面在该类中定义了`showUI()`方法，每次先清除canvas，重新画图，因为考虑到需要不断的进行刷新，因此把`controller`也设置为一个线程，在开始游戏后用`Timer`类的`schdule`方法，做有一定延时的任务来对UI进行刷新。
另一方面Controller也起到上帝的作用，对葫芦娃等生物进行排兵布阵操作，即初始化操作。

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
private ArrayList<Creature> allCreature; //存放所有生物的List
private ArrayList<Creature> goodCreature; //存放好生物
private ArrayList<Creature> badCreature; //存放坏生物

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

## Record类

有`startRecord`和`stopRecord`方法来对战斗过程进行记录。描述了每个生物的移动和作战过程以及最终结果。

## JavaFx
采用了`Canvas`类，因为按照老师的要求需要不断的对线程进行刷新以进行UI刷新，起初只知道Swing中的repaint方法有此功能，不知道在JavaFX该采用何种方法。后来
在stackoverflow上看到每次用一个长和宽分别为画布的矩形对画布进行遮盖，然后再重新loadImage，这样就起到了刷新的目的。


## 体现的设计原则

### SRP：单一职责原则

一个类尽量做到只有一个职责。例如`BattleFied`负责记录生物的信息，与图形界面分离，即不参与最后图像的展示。

### OCP：开放封闭原则

在基类中设计了一些抽象方法，以达到对扩展开放的效果。比如对于葫芦娃的排序方法实现了`Sort`接口，具有较强的扩展性。可以再加入其它排序方法。
同时对于子类无需访问内部的方法，标记为private。

### LSP：Liskov替换法则

只要父类能出现的地方，子类就可以出现，并且替换为子类也不会产生任何错误或异常。体现比较明显的是`Creature`和其各个子类之间的关系。

## 设计模式

### 组合模式

将生物对象与`Controller`构建的二维世界组合，由`controller`发号施令。


### 一些重构

* 在`Location`描述位置的类中使用了泛型`Location<T extends Creature>`,表示它是一个容器类，并且我们可以得知存放的类型。
* 异常处理机制：对于生物移动中移除棋盘的情况，添加了`ConflictException`类用于抛出异常。
* 使用多线程方式，并采用线程池的方法处理有多个线程需要同时运行的情况，使用`excute()`和`shutdown()`方法即可对线程池中的线程进行开始和杀死操作。
* 在原来的一些方法中使用了注解
* 对于世界创造的过程编写了测试方法。
* 使用maven进行了项目构建

## 存在不足
由于时间原因，生物的攻击方法和判定死亡方法没有能完全实现，只是编写了框架代码，还需近一步完善。同时我看到了老师发出的其它同学的项目展示，更加意识到了自己的不足。
因此我打算在寒假中继续重构我的代码，使他成为一个较成熟的小项目。

## 感想
作为一门跨院系的选修课，我没有像对待专业课那样投入特别特别多的时间，仅仅是按照老师的要求完成了阅读和重构的任务。但是经过一个学期的学习，回想起大一，感觉自己对面向对象思想有了更深一层的认识，同时也对Java的一些机制，设计模式等等
也有了一些程度的学习。因此无论最后成果如何，都非常感谢这门课带给我的知识以及一些知识以外的内容。
感谢曹老师和余老师。

