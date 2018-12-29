# 程序说明

## 1.类的划分
(1)Creature类：各种生物的基类，定义生物的基本属性，诸如类型、名字等等。其子类包括Brothers类、Grandpa类、Scorpion类、Snake类、Minions类等，分别表示葫芦娃、爷爷、蝎子精、蛇精、喽啰等生物;
(2)CalabashBrothers类：存储Brothers类的数组;
(3)Block类：表示战场空间中一个单位空间，包含一个Creature类对象(存储该单位空间内的生物);
(4)Troop类及TroopArray类：Troop类存储每个阵型的基本信息，包括名字、长度、宽度、所需数目及排布时各元素相对于基准偏移的横纵坐标，TroopArray类中则存储了一个Troop类数组，存储了已知各阵型的所有信息;
(5)Battlefield类：主类，用于完成战场和双方阵营的实例化，以及对战的过程，包含Creature类中诸多对象，Block类的二维数组，TroopArray类的对象.

## 2.类方法的实现
(1)Creature类及其子类：输出自身信息，基类中输出生物不存在的信息，各子类中覆盖为自己的输出方法;
```java
public void printinfo()
```
(2)CalabashBrothers类：Brothers类数组的初始乱序，排序算法，输出数组的信息;
```java
public void RandomArray()
public void BubbleSort()
public void ShowRank()
```
(3)TroopArray类：Troop类数组的初始化，根据序号返回对应的阵型信息;
```java
TroopArray() 
public Troop choose(int i)
```
(4)Block类：所拥有Creature类成员的放置、清空及信息输出;
```java
public void init()
public boolean put()
public void print()
```
(5)Battlefield类：葫芦娃、爷爷一方及蝎子、喽啰、蛇精一方阵型的放置，战场信息的打印;
```java
public void Calabashtroop(int x, int y)
public void Monstertroop(int x, int y, int select)
public void Showbattle()
```

## 3.设计小结
整个设计过程中，综合使用了继承、组合等多种面向对象的设计方法，提高了代码的复用率，在今后应去更好地学习应用面向对象的设计方法。

