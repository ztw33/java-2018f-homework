# 面向葫芦娃编程

## 一、目的/流程
1. 葫芦娃七兄弟随意站队 -> 冒泡法按年龄排行排序，报告动作 -> 报数
2. 葫芦娃七兄弟随意站队 -> 二分法按颜色排序，报告动作 -> 报数

## 二、类与对象
1. 葫芦娃 **CalabashBro**
	葫芦娃七兄弟作为排序的主角，当然必不可少。
	1. 考虑其属性/状态，一个葫芦娃有名字（同时反映年龄，如“老大”），有颜色，同时在队伍中也有对应的位置，因此CalabashBro需要有ownName、color、place字段。
	2. 考虑葫芦娃的行为，一个葫芦娃可以告诉别人自己的名字、颜色，还可以设置/改变自己的位置（走到指定的位置），因此CalabashBro中需要有如下方法：
	getName、getColor、setPlace、changePlace，
	另外，在构造函数中对其进行初始化。
	3. 考虑到葫芦娃只有确定的七个，并且其名字、颜色都是确定的，为防止创建对象时，创建定义过多的、奇奇怪怪的葫芦娃（如老九-黑色），将CalabashBro置为enum类型。

2. 颜色 **Color**
	葫芦娃需要根据颜色排序，为方便颜色的比较，同时考虑到葫芦娃的颜色也只有确定的7种，因此，也将其颜色Color置为enum类型，同时定义RED等7个实例。

3. 葫芦娃队列 **CBQueue**
	七兄弟整体需要做的是什么？随意站队、依次报数，这些行为其实可以视为整个队列的行为。
因此，可定义CBQueue类，将这两种整体行为封装：
	1. 内置CalabashBro[] broQueue作为整个葫芦娃兄弟数组的引用，并于构造函数中初始化。
	2. 定义randomQueue方法，利用java.util.Random中的Random类实现随意站队。
	3. 定义countOffAcName、countOffAcColor，使七兄弟分别根据姓名、颜色报数。

4. 排序器 **SortAndCount**
	七个葫芦娃没有办法自己排序，因此需要有一个开启“上帝视角”的排序器，指挥他们进行排序：
	1. 定义SortByName、SortByColor方法，分别对七兄弟队列按名字、颜色进行排序。
	2. 排序时需要的算法，则由SortAlg类（见下文）的alg确定（类似与一个引擎/cpu吧），SortByName、SortByColor方法中则利用alg实现。

5. 排序算法 **SortAlg** 及其子类 **BubbleSort**、**BiSort**
	将SortAlg置为抽象类，内设sort抽象方法，具体实现则由BubbleSort、BiSort实现。由此，在排序器SortAndCount类中，引擎alg只需要创建具体对应的排序算法类（冒泡或二分），再直接调用sort即可。
	另外，在sort的具体实现中，排序时均需要告诉葫芦娃移动到具体的位置（changePlace），而其在移动过程中则报告自己的位置变化。

由此，可实现葫芦娃七兄弟排序-报数的过程。
