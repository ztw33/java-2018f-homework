# 实验报告



## 代码结构

### Creature接口

Creature接口将两个枚举类：CalabashBrother以及NonCalabashBrother组织在一起。使用枚举类的好处是比较符合每个生物体都是Singleton的实际情况，而由于Java不支持多继承，使用Delegate模式模拟"abstract enum"。



### Coordinate类

提供一个坐标工具类，方便后续涉及坐标的相关操作。



### Cell类

描绘战场上每个独立的单元格。单元格上包含一个坐标以及一个生物体，提供添加生物体、移除生物体等原子操作。



### Formation枚举类

描绘每一种阵型包含的战场上位置的坐标，包括leader坐标、soldier[]坐标以及supporter坐标。instantiate方法根据提供的leader坐标、supporter坐标参数对阵型坐标进行实例化。soldier[]坐标会根据leader坐标以及所属阵型来确定（使用枚举类内的抽象方法，可以对每一种阵型的soldier[]坐标进行定制）。



### Camp抽象类

描绘战场上的阵营。阵营中包含leader生物体、soldier[]生物体集合、supporter生物体以及Formation阵型等属性，这些属性由CampProperty类代理。CalabashCamp和NonCalabashCamp继承自Camp抽象类，其中CalabashCamp中扩展了排序等方法。



### BattleField类

描绘战场。战场由二维的Cell数组构成。可以向其中添加生物体、阵营。

由于阵营可以变换阵型，为了能让战场感知到阵营的变化，采用Observer模式监察阵营的属性，一旦阵营发生变化，战场可以相应地进行同步更新，从而保持不同对象之间状态的一致性。



### Test类

测试功能实现的正确性。

