设计说明
======
面向对象设计思想
------

## creature包：  
 定义了所有生物的接口和类，所有生物都要实现creature接口  
  #### Creature接口其中定义了三个抽象方法：  
    获得自身对象的显示字符 symbol()  
    到战场battlefield中的某位置中进入战斗 move()  
    从战场的某位置撤退 leave()  
  Huluwa,Grandpa定义为enum类  
  Monster为所有怪物的基类，小怪Minion，蛇精Snake，蝎子精Xiezi继承Monster  
  Cheer接口定义了cheer函数，Grandpa和Snake实现Cheer接口  
## battlefield包：  
  战场BattleField为矩阵，大小可以自己定义，包含了N*M个 Position对象
  Position类为一个坐标，并维护一个Creature对象的引用  
## zhen包：  
  抽象类Zhen，其中私有成员定义了阵列的初始位置
  子类实现了start摆阵和runaway撤退  
## group包：  
  打架是两个阵营在打，所以定义了HumanGroup和MonsterGroup，实现各自阵营成员的初始化和功能函数

运行结果
------
 ![image](https://github.com/moon19971102/java-2018f-homework/tree/master/20180925/叶超-151180159/display.PNG)
