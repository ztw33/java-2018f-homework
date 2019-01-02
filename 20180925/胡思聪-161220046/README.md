# 作业3
## 用接口组织枚举
实验要求: 葫芦娃、老爷爷、蛇精、蝎子精、小喽啰均属于生物体。该空间中的任意一个位置坐标上可站立一个生物体
葫芦娃、老爷爷、蛇精、蝎子精、小喽啰均应该继承生物体类。但是葫芦娃、老爷爷、蛇精、蝎子精又是有限且唯一的，应该用枚举类型。
而在Java中不允许多继承。所以枚举和继承难以同时实现。
对于enum而言，实现接口是使其子类化的唯一办法。所以尝试使用接口组织枚举
```
interface Creature{
    public void move_to(BattleField x, int i, int j);
    public String getname();
    
    enum NULL implements Creature{...}
    enum CalabashBrothers implements Creature{...}
    enum Grandfather implements Creature {...}
    enum Serpent implements Creature {...}
    enum Scorpion implements Creature{...}
    enum monster implements Creature {...}
}
```
但是对于实验中每一个子类型,具有相同的方法。用接口会使得代码重复。在该实验中并非好的实现。
## 战场类
战场类用Creature类的二维数组构成。每个战场单位都可以放一个生物体。战场类具有打印战场的方法。

## justice类
由葫芦娃构成
## evil类
由蝎子精和小喽啰构成
## 阵法接口。
justice类和evil都implements了阵法接口。每个类按具体情况分别实现接口。按阵法类型命令生物站在战场的相应位置。
## 调度者类
调度执行
