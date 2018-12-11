# 实验报告
## 文件结构
这次作业文件比较多，将它们放在不同的package里可以较好地组织管理，控制访问。<br>
![](image/structure.png)
## UML图
![](image/UML.png)
## 相关说明
(1) 我将Creature设置为一个接口，Grandpa，Huluwa和Monster类各自实现了接口中的`printName`方法，即返回相关生物的名字。Snake，Scorpion和Loluo类继承了Monster类，并重写了Monster类中的`printName`方法。<br>
(2) 在我的设计中，各种生物自己都是不能移动的，所以组成战场的基本单元Block类提供了`putCreature`，`eraseCreature`和`showCreature`的方法，帮助生物进入和离开。Battlefield类中用一个Block类型的二维数组表示战场，并实现了各种阵法和战场的打印、清除功能。God类实现了最高级别的调度器的功能，这只上帝之手创造了战场及战场上的各种生物，还实现了对葫芦娃的排序。<br>
(3) 接口Cheerable表示具有加油助威的能力，Grandpa和Snake都实现了接口中的`cheer`方法。
## 关于面向对象
本次作业使用的面向对象的概念有<br>
**继承和多态**：Monster类是所有怪物类的基类，各个子类又重写了父类中的方法。<br>
**接口**：Creature和Cheerable都是用接口实现的。<br>
**组合**：比如在Battlefield类的成员变量中，有Block类的二维数组。<br>
```java
public class Battlefield {
    private Block[][] battlefield;
    ......
}
```
**package**：将与生物的class和与战场有关的class放在不同的package中，便于组织管理与控制访问。
## 运行效果
![](image/result.png)
