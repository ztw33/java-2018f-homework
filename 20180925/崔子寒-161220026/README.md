# 相关说明
## 11月6日  重构说明
##### 1.原本一些使用数组的地方，改为了使用持有对象。另外对于葫芦娃的排序，由于使用了持有对象，所以不再用自己写的算法，而是使用了**Collections.sort**方法。具体包括：
+ Heros.java
```java
//private CalabashBrother[] calabashBrothers;
private ArrayList<CalabashBrother> calabashBrothers = new ArrayList<>();
```
+ CreateEverything.java
```java
//private static Monster[] monsters;
//private static FormationProvider[] formationProviders;
private static ArrayList<Monster> monsters;
private static ArrayList<FormationProvider> formationProviders;
```
+ Battlefield.java
```java
//private Block[][] battlefield = new Block[10][20];
private ArrayList<ArrayList<Block<Creature>>> battlefield = new ArrayList<>();
```

相应的，有遍历数组的操作之处用迭代器遍历的方法进行代替。

##### 2.使用泛型的方法重构了代表单位空间的Block类。  
+ Battlefield.java
```java
//class Block
//更直观的表明了Block可以持有任意的Creature派生类。
class Block<T extends Creature>
```

## 设计
### 1. 类的划分
对具有不同功能的类进行包管理。
(1) Creatures包括：抽象基类Creature,派生类CalabashBrother，Grandfather，Snake，Monster和Scorpion。另外蛇精和爷爷继承了接口Cheer，拥有cheer()方法，另外认为葫芦娃是可以根据颜色进行排序的，因此CalabashBrother实现了**Comparable接口**的compareTo方法。
![image](https://github.com/czhnju161220026/image/blob/master/res3class.png?raw=true)

(2) Attributes包中的类描述了生物应该具有的属性，目前包括Position和Color两个属性，分别表示生物在战场中的位置，以及葫芦娃的颜色。
(3)Formations包提供了阵型数据的功能。接口FormationProvider定义了一个阵型类应该具有provideFormation方法，返回一个坐标数组。所有的阵型类都继承自这个接口。
![image](https://github.com/czhnju161220026/image/blob/master/res3class2.png?raw=true)

(4) Battlefield类：二维空间类，类内部有一个Block对象的矩阵。
(5) Block类：Block类代表一个单位空间，使用泛型的方法，它可以持有任意Creature子类。
(6) Heroes类：代表正义阵营。正义阵营可以完成葫芦娃排序，置乱的功能。
![image](https://github.com/czhnju161220026/image/blob/master/res3class3.png?raw=true)
(7) CreateEverything类：完成创世界的的任务。


### 2. 类方法的说明

(1) Creature及其派生类:
``` java  
/*输出自身信息，在派生类中被分别覆盖为所需要的方法*/
public void outputInfo(); 
```
(2) Block&lt;T extends Creature&gt;:
``` java
/*绑定生物*/
public boolean creatureEnter(T creature);
/*生物离开*/
public void creatureLeave();
/*输出信息，直接调用所绑定生物的outputInfo()*/
 public void outputInfo();
```

(3) Battlefield:
``` java
 /*遍历二维空间，打印战场的实时情况*/
 public void print();
 /*清空战场*/
 public void clear();
 /*生物进入坐标为（i,j）d的空间*/
 public void creatureEnter(Creature creature, Position position);

```

(4) Heroes:
``` java
/*置乱方法，用来生成乱序的葫芦娃队列*/
 public void shuffle();
 /*葫芦娃按序排队，进入战场*/
 public void lineUp(Battlefield battlefield);
```

(5) FormationProvider接口
``` java
/*给出一个坐标数组，描述指定的阵型*/
Position[] provideFormation();
```

(6) CreateEverything类
``` java
/*初始化工作：实例化怪兽，葫芦娃，葫芦娃置乱，排序*/
public static void init()；
/*葫芦娃进入战场*/
public static void herosEnter();
/*怪物变阵*/
public static void badGuysChangeFormation(FormationProvider formationprovider);
/*main函数*/
init();
for(FormationProvider fp:formationProviders) {
    herosEnter();
    badGuysChangeFormation(fp);
    battlefield.print();
    battlefield.clear();
    Thread.sleep(1500);
}
```




## 面向对象的特性
1. 继承：CalabashBrother,GrandFahter,Monster继承了基类Creature
2. 组合：Battlefield的成员有Block对象的矩阵，Block的成员中有Creature及其派生类的对象。
3. 多态：在遍历空间，输出战场信息的时候，调用每个Creature对象的outputInfo方法，这些方法会动态绑定到具体的子类中的方法，运用了多态的思想。
4. 泛型：Block类运用了泛型的思想，直观的说明了其可以持有任意的Creature及其派生类。

这些设计思想提高了代码的复用效率，而且和现实世界比较类似，是以后的学习过程中应该多加运用，多多领悟的。

## 运行效果

![image](https://github.com/czhnju161220026/image/blob/master/res3v2.png?raw=true)



