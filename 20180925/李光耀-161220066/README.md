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





