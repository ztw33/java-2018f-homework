# Java第三次作业
## 设计思路与实现细节
![framework](https://raw.githubusercontent.com/justisement/the-3rd/master/pic/1.PNG)
- 如图我一共分了三个package包括Creature、Formation和World，分别包含了人物、阵型、以及所抽象的葫芦娃世界，并在此开启了整个世界的入口。无论是老爷爷还是葫芦娃还是小喽啰都是生物，因此他们都继承了Creature生物类。
- Creature包括两个比较重要的属性
 ![creature](https://raw.githubusercontent.com/justisement/the-3rd/master/pic/3.PNG)
 这里的Posistion是自己设计的位置类，包含x、y坐标信息，以及设置位置、读取位置的方法
- 每一个creature又有move的方法，实现了对象的操作--移动到具体位置（其实也就是设置其位置坐标）
- Formation里包含所有的阵型、阵型默认从（0，0）坐标开始，也就是说，在打印地图时，我还会给出一个位置信息，对阵型中的每一个人物整体进行位移并放置在地图上。阵型是观察其规律后，creature.moveto()完成。
![setFormation](https://raw.githubusercontent.com/justisement/the-3rd/master/pic/4.PNG)
- World是整个程序的入口，对对象实例化并进行对葫芦娃和小喽啰数组排列阵型、放置在地图、打印地图等相关操作。
- Space是实现整个对峙局面的舞台，我定义了一个类型为Contain的二维数组map，Contain存储该位置是否有人、如果有那么所存储的Creature具体是那个等信息。如此，最后调用Space中的方法打印地图、放置creature即可完成题目要求。


---
从面向对象的角度来“面向葫芦娃”编程，很给人一种创世纪的感觉。“万物皆可为对象”，一步步的创建对象，设计方法，实现需求，整个过程是十分流畅而自然的。整个框架也清晰明了。相应地，Collection、泛型等也为我提供了许多便利。比如，我的葫芦娃初始化乱序排列，就是以Collection.shuffle()完成的。

## 问题思考
- 继承作业2的思想，每一个葫芦娃是葫芦类的对象，使用了枚举。但由于在这次作业中，葫芦类又继承了Creature类，enum类不能被继承。
- “高内聚、低耦合”实现得不是很好，一开始的模块划分可能就有一定问题，实现时也没能做到设计得更为精妙。创建一个世界固然很爽，但还是需要在每一个地方进行更多更深的思考才行。
## 实现效果
![result](https://raw.githubusercontent.com/justisement/the-3rd/master/pic/2.PNG)

---
实现图形化暂时出现了一些问题，这里先交上一个简略版。
