设计理念
====
* Main函数是一个创世纪的过程，到目前为止，一共产生了排序调度者和战场调度者两个上帝；
* 葫芦娃受老爷爷指挥，蝎子精以及小喽喽受蛇精指挥，而所有一切都是继承一个生物类；
* 战场抽象为一个类，分别由老爷爷和蛇精排布双方阵形；
* 战斗本身由战争调度（BattleScheduler）者掌控；
* 老爷爷和蛇精的助威暂时只将他理解为将两者至于战场的某一位置，等待后续补充。

面向对象机制
====
继承
===
* 考虑到蛇精，蝎子精，葫芦兄弟等具有某些相同的属性，如名字，位置，动作等等，所以创建一个基类Creature，便于后期添加各种操作手段；
```Java
 public class Creature{ }
 class Grandpa extends Creature{ }
 class Calabash extends Creature{ }
 class Soldier extends Creature{ }
 class Snaker extends Creature{ }
 class Crab extends Creature{ }
```

封装
===
BattleField类表示战场，对外隐藏战场大小，只对外提供InitField,PrintField等方法进行初始化战场以及输出战场信息的功能

静态成员的使用
===
因为整个程序背景中出现的生物都是唯一的，所以只支持一次创建，也就是说之后的所有操作都是在已有的成员对象上进行操作，所以在Creature类中定义了这些静态成员
```Java
    public static Calabash calabash[] = new Calabash[7];
    static Random p = new Random();
    public static int num = p.nextInt(15);
    public static Soldier soldier[] = new Soldier[num];
    public static Grandpa grand_pa = new Grandpa();
    public static Snaker snaker_ = new Snaker();
    public static Crab crab = new Crab();
```
使得在第一次调用Creature类时，这些静态成员就已经创建，后面就不需要再进行单独创建了。
