<u>**Version 3**</u>

在版本2中引入泛型。修正措施如下。

1. 将`Board`中每一个元素`Square`进行泛型化修改。

   ```java
   public class Square{
       private Object being;
   }
   ```

   ```java
   public class Square<T extends Being>{
       private T being;
   }
   ```

   将`board`由`ArrayList<ArrayList<Square>>`类别改为`ArrayList<ArrayList<Square<Being>>>`。

   将`formation`由`ArrayList<Square>`类别改为`ArrayList<Square<Being>>`。

2. 在版本2中存在bug。主要由于妖怪不断切换阵型时可能导致待切换的阵型中已经有老爷爷、蛇精挡着。此时应该不能发生切换，需要移动老爷爷、蛇精的位置。对该代码进行fix(其实版本1是没有这个问题的，在版本2重构时疏忽了)。

3. 在循环生成妖怪阵型时，使用工厂方法实现。

   ```java
   interface Factory<T>{
       T create();
       T back();
   }
   ```

   ```java
   class FormationFactory implements Factory<Formation>{
       public Formation create();
       public Formation back();
   }
   ```

   在`FormationAdminister`中使用`FormationFactory`循环生成阵型。



----



<u>**Version 2**</u>

Version1版本存在的问题以及修正措施。

1. `Creature`中还有`CreatureType`属性，这是不必要的，可以使用`RTTI`在运行时动态判定对象类别。

2. `Formation`没有作为一个抽象类，使用者可以故意对其进行显示实例化。由于我是在构造函数中对`Formation`里的数据进行初始化，其他情况下不会再进行修改，故在`Formation`中我没有添加抽象方法。

3. 在看很多位同学在`README`中描述对类的功能划分时，发现他们都划分的很细致。于是，我在原先`creature`包的基础上，追加引入`Being,GoodCreature,BadCreature`。便于后期各种活动体拓展。同时原来我的加油助威逻辑是放在`UI`模块中，现在放在内部模块。将加油助威抽象为一个接口，`Human,SnakeEssence`分别实现这个接口。目前实现的加油助威内容只是往`JTextArea`写入一句话而已。

   新的类图如下所示(和很多同学的设计大同小异)。

![creatureUML](https://github.com/lidayou/java-2018f-homework/blob/master/20180925/%E6%9D%8E%E5%85%89%E8%80%80-161220066/creatureUML.png)



4. 由于已经不只有生物体了，将来还可能引入非生物体，将`CreatureImage`改名为`StypeImage`，使得名称更准确。
5. 在张明超同学的`README`中提到阵型应该和生物体解耦，也应该和场地的大小无关。我觉得很对。原来我的每一个阵型是坐标和生物体同时初始化，然而位置是位置，生物体是生物体，两者应该独立。为此，对于管理类来说需要更细致的划分。这也在一定程度上体现了`SOLID`原则的`S`，每个类应该具有单一的职责。为此新的`regulate`包中管理类的关系如下所示。

![administerUML](https://github.com/lidayou/java-2018f-homework/blob/master/20180925/%E6%9D%8E%E5%85%89%E8%80%80-161220066/administerUML.png)

	

5. (续)管理类具体职能如下：Administer作为UI界面与内部具体实现逻辑部分的桥梁。UI只与	Administer类打交道。为此定义一个接口`LinkGUI2Inside`用于对两者之间的通信、联系的规约(这个接口联系起了整个系统的框架，应该在设计之初就确定下来)。Administer将功能指责划分为4份，`BoardAdminister`用于管理`Board`工作，主要有物体移动、清盘、放置阵型等功能。`GoodManAdminister`主要用于好人阵营的管理，包括对老人(老人要加油助威)，以及葫芦娃兄弟管理者`HuLuWaAdminister`的控制，同时完成对`Formation`里具体生物的填充(好人生物)。`HuLuWaAdminister`完成对七兄弟的排序、乱序等工作，其控制对象为`HuLuWa`数组。`BadManAdminister`主要控制蛇精以及对地方阵型中坏人生物的填充。`FormationAdminister`主要用于循环生成阵型。只生成坐标，不填充具体的生物体。填充具体的生物体由上面`GoodManAdminister`和`BadManAdminister`完成。而具体阵型的放置则由`BoardAdminister`完成。如此将放置阵型这一指责分散为三方独立协作完成，一定程度上体现了接口隔离原则。
6. 关于移动生物体那块，老师在上课时提了个问题(我是通过数字坐标来确定上下左右的)"如果上下左右的概念变了如何"，在先前的设计中，上下左右的概念是我写死的。听了老师的问题，我觉得需要将其单独抽出来。定义一个方向向量类`DirectionVector`，其中蕴含一个坐标向量。在`BoardAdminister`中定义四个静态方向向量，分别表示上下左右(完成舒适化)，以后每次坐标移动，只需加上这个方向向量即可。如果方向的定义放上了变化，只需重新定义这四个静态方向向量。
7. 引入集合框架，将原先自己用数组完成的数据结构用`ArrayList`代替。如此，在对葫芦娃排序、乱序时，可以直接使用集合框架中的函数。同时可以看出这种实现跟老师之前提到的排序实现是相同的。将具体的实现算法和两两元素的序关系相互隔离开来。
8. 在`github`上查看其他同学的设计时，发现自己不怎么情愿去读别人的代码，最后都是简单得读了下`README`。本着互利互惠，便于相互学习的态度，决定参照马白家欣同学那样，添加文档注释。



---





<u>**Version 1**</u>

# 设计思路:

面向对象的概念、机制、理念

## 抽象、封装

由于本题涉及的对象众多，采用包管理。引入4个包。creature包用于描述各种生物体，以及相关枚举属性。space包用于描述二维空间以及阵法。regulate包用于描述对游戏整体的管理。gui包用于描述相应的图形界面以及根据游戏流程调用游戏整体管理的相应方法。具体结构如下。

![packet](https://github.com/lidayou/java-2018f-homework/blob/master/20180925/%E6%9D%8E%E5%85%89%E8%80%80-161220066/packet.jpg)

概括而言，通过层层抽象、封装，分解任务，使得任务模块化。

### 总体构建的世界

二维空间`Board`由一个单元格`Square`组成，每一个单元格可以放置一个生物体`Creature`。通过单位格的移动实现生物体的移动。`Board`可以管理单位格的移动，也可以实现不同阵法`Formation`的切换。但`Board`不直接向界面暴露，通过`Administer`实现`Gui`与`Board`的协调。



### 具体示例

由于葫芦娃七兄弟往往需要统筹管理(排序、乱序等)，故采用HuLuWaAdminister类管理一个静态的七兄弟数组。主要提供两个接口排序、乱序供外界使用。

```java
public class HuLuWaAdminister{
    private static HuLuWa[] brothers;
    public static void shuffleHuLuWas();
    public static void sortHuLuWas();
    ......
}
```



对于二维空间的构造，首先确定一个基本的单元Square的属性。由一个二维Square数组组合成一个Board类(代表游戏二维空间)，呈现出一个严格的整体与部分的关系。

```java
public class Square{
    private int x;
    private int y;
    private Object being;
    ......
}
```

```java
public class Board{
    private Square[][] board;
    ......
}
```

同时由于Board类的特殊性，它同时也是一个二维空间的管理者，可以改变怪物的布局、清理场上现有的布局等功能。这些功能作为接口向外暴露。



最后，有一个统筹的管理者，Administer类(位于regulate包中)，用于协调界面与内核部分。界面中的点击事件、键盘事件都通过Administer类中的方法指导内核进行相应处理。同时内核中相应处理事件的结果也通过此向外传递。可以说Administer类是内部所有事物的统筹者。

```java
public class Administer{
    private Board myBoard;
    public void getputNextMonsterFormation();
    public void getputHuLuFormation();
    public void putGrandpa();
    public void putSnake();
    ......
}
```



### 总结

通过类的抽象任务完成从问题空间到解空间的映射，同时通过封装使得每一个类成为一个黑匣子，只通过接口向外暴露，同时充分隐藏内部细节。



## 继承

由于空间中的生物体有着众多相同的属性，故创建一个基类Creature，描述公有属性。葫芦娃、小怪、蛇精、蝎子精类都继承于此。后期可以在基类上进行拓展属性、方法，有效实现代码复用，同时子类也可以充分拓展自己独特的属性。我没有将Creature设计为一个接口，因为接口描述一系列规约(方法)，不能拥有自己的属性，这与现实世界的Creature不相符。后期思考中探寻将Creature设计为抽象类的可能性。本题中或许可以将Creature设计为抽象类，强制使得调用者不能实例化Creature，必须自己创造一个物种类继承Creature使用。这是设计为抽象类的好处。

```java
public class Creature{
    private CreatureType type;
    private String name;
    private CreatureImage image;
    ......
}
```



同时我也创建一个阵法的基类，不同的阵法继承于此。通过基类向外暴露的接口来获取不同的阵法。这里基类的方法`getNextMonsterFormation()`对子类也是通用的。

```java
public class Formation{
    protected int num;
    protected Square[] formation;
    public static Formation getNextMonsterFormation();
    ......
}
```



由继承则引入了面向对象中的多态概念。这里不同的生物体，不同的阵法都可以向上塑形(upcast)为其基类，这样相应管理者的代码就更具有通用性。只使用基类类型就可以覆盖不同子类的情况。



## 界面与内部事物

设计中采取完全分离的方式实现。内部存在着一个用于管理真实事物的矩阵`Square[][] board` ，而界面也对应着用于显示的矩阵`JLabel[][] background` 。两者相互对应。界面中加载真实的图片，而内部事物中只是通过一个枚举类`CreatureImage`来标识生物图片信息。 通过这种分离，降低界面与内部事物的耦合程度，使得后期拓展时能够着重于内部事物的修改。



# 效果图

通过按钮点击变换阵法。通过上下左右移动老爷爷、蛇精(先老爷爷后蛇精)，移动到合适位置后按`S`固定位置。每次变换阵法后，老爷爷、蛇精都需要重新固定位置。

![result](https://github.com/lidayou/java-2018f-homework/blob/master/20180925/%E6%9D%8E%E5%85%89%E8%80%80-161220066/result.jpg)





