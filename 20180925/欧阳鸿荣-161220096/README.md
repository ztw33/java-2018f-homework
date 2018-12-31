# 作业三：葫芦娃 vs 妖怪

161220096 欧阳鸿荣

[TOC]

## 0.概述

| 开发环境               | 运行环境 | 最后一次更新 |
| ---------------------- | -------- | ------------ |
| IntelliJ IDEA 2018.2.2 | JDK 1.8  | 2018/12/17   |

## 1.更新日志 Version 2.3

主要更新内容：用Maven，JavaFx结合注解、单元测试重构了程序。可以在顶端菜单栏设置起始阵型，并能够在3s之后，在判断冲突的前提下让葫芦娃和妖怪们随机移动（多线程情况下），为最后大作业的实现奠定了基础。这也是迭代的最后一个版本，下次更新将在FinalProject中。本次代码放在```src/calabashBoys```目录下。

<div>
    <img src="images/final.png"/>
</div>



## 2.更新日志 Version 2.1

主要更新内容：用 RTTI,Collection Framework 和Generics重构了程序，针对课上问题进行了部分修改

### 1.RTTI的运用

此前的程序中，用了一个名为```CreatureType```的枚举类，意图是为了确定类的类型。但是学了RTTI后，删去了跟该类有关的结构，在使用父类对象引用表示的子类对象时，用```getClass().getSimpleName()```来得到类的信息。

### 2.Collection的应用

此前的程序中，使用的是Java中的一位数组和二维数组用来存储，这次重构中，统一使用```ArrayList```来表示数组，同时程序中也用了```HashTable```等容器，增加了安全性和便利性。

对于二维数组，起先其实是不打算用容器来重构，但是由于数组的元素被我用泛型重构了，因此我遇到了“无法定义泛型的数组”的问题，因此我用一个看上去略复杂的结构来表示```ArrayList<ArrayList<unit<T>>> maps;```

不过这个结构也有一些方便，就是更好地表示了二维数组的存储方式。

### 3.Generics的应用

这个应该是本次重构中重构范围最广的应用了。通过泛型的使用，将许多方法和类解耦，扩大了其适用范围，也增加了程序的可扩展性。

------

## 3.更新日志 Version 2.0

### 1.程序主要的UML图

#### a.生物

<div>
    <img src="images\1.png" width=70%>
</div>


#### b.阵法

<div>
    <img src="images\2.png" width=100%>
</div>




### 2.程序划分

程序主要分4部分：表示生物的**Beings**，表示阵法的**Formation**，表示战场的**BattleField**和调度器**God**

下面分别阐述代码中用到哪些面向对象的概念、机制、设计理念，以及这样做的目的和好处

#### a.Beings 存在

正如上述UML图中所示，在Being中主要处理的是葫芦娃、爷爷、蝎子精、蛇精、小喽啰等的关系，

在写作业二的时候，对于葫芦娃是用了枚举类型，以便限定葫芦娃的个数等特征。但是在这次作业中，由于考虑到在施展阵型中，利用多态和继承关系带来的极大便利性，因此在经过一番考虑后，采用枚举类限制初始化各个生物的状态，因此有了如下4个枚举类：

| 类名            | 意义         | 内容                                               |
| --------------- | ------------ | -------------------------------------------------- |
| CalabashName    | 葫芦娃的姓名 | 老大，老二，老三，老四，老五，老六，老七           |
| Color           | 葫芦娃的颜色 | 红色，橙色，黄色，绿色，蓝色，靛色，紫色           |
| CreatureType    | 生物的种类   | 人类，葫芦娃，怪物，妖怪首领                       |
| EnumCalabashBoy | 七个葫芦娃   | 类似作业二中，把每个葫芦娃对应的颜色和姓名等初始化 |



有了以上的枚举类后，对于生物，尤其是葫芦娃的初始化就限定在了一定范围内，因此创建了以下7个类

| 类名        | 继承于   | 解释                                 | 物种     |
| :---------- | -------- | ------------------------------------ | -------- |
| Beings      | Object   | 存在，是一切的基础                   | Null     |
| Creature    | Beings   | 生物                                 | Null     |
| CalabashBoy | Creature | 葫芦娃                               | 葫芦娃   |
| Grandpa     | Creature | 爷爷                                 | 人类     |
| Monster     | Creature | 普通妖怪                             | 怪物     |
| Scorpion    | Monster  | 蝎子精，脱胎于普通妖怪，是更强的存在 | 妖怪首领 |
| Snake       | Monster  | 蛇精，，脱胎于普通妖怪，是更强的存在 | 妖怪首领 |



蛇精和爷爷要如何加油呢？

这时候想到课上讲过的接口的概念，让不同类的可以共享并且重写自己的加油方法。因此定义了两个接口**CheeringUp**和**Fighting**（Fighting的定义是为了给阵型中的生物使用，但是具体的实现没有给出）

```java
public interface CheeringUp {
    void CheeringUp(Maps maps, int x, int y);
}

public interface Fighting {
    void Fighting(Maps maps,int x,int y);
}
```

于是，运用继承和接口，让生物间的关系变得更加有序，也使得程序的组织和语义都有了更好的约束。



#### b.Formation 阵法

阵法，实际上就是让特定的人，在特定的地图上的特定位置摆出特定队形，因此无论是何种阵法，都是一样的原理，因此在此，定义了抽象类**Formation**

```java
abstract public class Formation {
    protected int startX;   //阵法领导者的X坐标
    protected int startY;   //阵法领导者的Y坐标

    public Formation(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
    }

    abstract public void SetFormation(Maps maps, Creature[] creatures,int direction);
    ....
}
```

正如上述UML图所示，一共有8个类继承并且给出了**SetFormation**方法的具体实现，分别对应8种阵法



#### c.BattleField 战场

为了表示地图并且实现GUI，我实现了3个类

| 类名        | 解释                                         | 描述                 |
| ----------- | -------------------------------------------- | -------------------- |
| Unit        | Creature的容器，拥有坐标                     | 空间上的格点         |
| Maps        | 由Unit组成的二维矩阵                         | 战场的地图，二维平面 |
| BattleField | 实现GUI的类，将传入的Maps类的对象通过GUI显示 | 战场GUI的显示        |

在**Beings**和**Formation**中都或多或少运用到了Maps类，这让生物和阵型能够自己在地图上寻址，更符合实际情况，也体现了面向对象设计的理念。在Maps和BattleField的输出实现中，都根据枚举类使用了switch语句来输出特定的内容，利用了switch和enum的有机结合，使得程序更安全。



#### d.God 调度器

God类相当于一个调度器，用于控制各个生物类的创生以及各个阵法的对峙，实现等，并且控制GUI的显示，战场的重置，对峙的休眠等等。



### 3.程序效果

#### a. CMD输出

C代表葫芦娃，G代表爷爷，L代表蝎子精，M代表小喽啰，S代表蛇精

<div>
    <img src="images\3b.png" width=60%>
</div>



#### b. GUI显示

<div>
    <img src="images\4.png" width=50%>
 	<hr/>
    <img src="images\5.png" width=50%>
    <hr/>
    <img src="images\6.png" width=50%>
    <hr/>
    <img src="images\7.png" width=50%>
    <hr/>
    <img src="images\8.png" width=50%>
</div>




### 4.程序亮点与思考

#### a.亮点

(1) 运用了继承、抽象类、接口的技巧，使得程序的组织更加有趣，更符合面向对象的理念，更接近现实

(2) 运用了枚举类，将对象的内容限制在一个有限的集合内，更加符合实际，也使得程序更安全

(3) 实现了阵型的GUI表示，更加生动

#### b.思考与不足

(1) 加油我的实现就是用一个接口来实现，让蛇精和爷爷能够主动出现在战场的某个位置，但是有点别扭

(2) 阵型的实现，除了长蛇，雁行，冲轭阵的适用范围较为广泛以外，其他的阵型都受到较大的限制

(3) 对于阵型的冲突以及溢出都只做了初步的判断，程序的鲁棒性还不足。 