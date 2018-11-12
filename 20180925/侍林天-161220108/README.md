#rewrite with generics
##改写Tile类
* public class Tile<T extends Creature> {
    private T creatureStandOnTile;
}
##改写TwoDimensionSpace类
* public class TwoDimensionSpace<T extends Creature> {
    private Tile<T> space[][];
}

# 面向葫芦娃编程3：阵型
***
## 需求分析
* 我们要实现葫芦娃和妖怪在一个二维平面上不停变换阵型进行对阵。
* 需要一个二维平面，该二维平面由一个NxN的砖块组成。砖块上可以站立一个生物体。

## 设计分析

### Tile类
* Tile是构成一个二维空间的基本单位。拥有X坐标，Y坐标，砖块上站立的生物体等属性。
* Tile有boolean isEmpty()，void removeCreatureStandOnTile()，void setCreatureStandOnTile(Creature x)，String getCreatureName()等接口供外部调用。
* boolean isEmpty()可以判断该砖块上是否有生物体
* void removeCreatureStandOnTile()可以将砖块上的生物体移除
* void setCreatureStandOnTile(Creature x)可以添加一个站在该砖块上的生物体
* String getCreatureName()可以获得站在该砖块上生物体的名字

### TwoDimensionSpace类
* TwoDimensionSpace类由一个N*N的Tile类的矩阵构造。TwoDimensionSpace可以通过Tile类提供的原子操作，为生物体提供更高级的接口，让生物体在二维空间里自由地移动。
* boolean setSpace(int x, int y, Creature p)会在坐标(x, y)不越界且坐标(x, y)为空的情况下将生物体p放置在坐标(x, y)上。
* void cleanSpace(int x, int y)在坐标(x, y)不越界的情况下会将坐标(x, y)清空。
* void displaySpace()提供接口将二维空间的情况打印出来。

### Creature类
* Creature作为基础的生物体拥有名称，坐标等属性。
* 拥有接口可以获得当前属性，坐标。
* 拥有方法public boolean moveTo(TwoDimensionSpace space, int x, int y)，可以让该生物体移动到给定二维空间的指定坐标。
* 拥有方法public void removeFrom(TwoDimensionSpace space)，可以让该生物体离开给定二维空间。

### HuluWa类
* HuluWa类从Creature类继承而来，在Creature类的基础上多了排行、颜色等属性。并提供了葫芦娃之间基于颜色、排序进行大小比较的接口。

### Formation类
* Formation类用于排阵。它有一系列的接口例如void generateChangsheFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction)，可以让给定的一组Creature类的对象在给定二维空间里，以（x，y）为中心点进行排阵，direction用来控制朝向。

### Team类
* 考虑到葫芦娃阵营和妖怪阵营要摆出不同的阵型，所以设计来Team类来协调多个生物体之间的协作。
* Team类有一个Creature组合的数组作为战斗人员，并有成员observer留给爷爷和蛇精作为啦啦队。
* Team类拥有一系列名为generateXX(TwoDimensionSpace space, int x, int y, int direction)的接口。该接口实例化一个Formation类，然后调用Formation类的方法，让战斗人员在给定二维空间以某一坐标为中心点进行排阵，direction用来标识方向。
* Team类还有一个接口void setObserver(TwoDimensionSpace space, int x, int y)用来放置加油的拉拉队员。

### HuluBrothers类
* HuluBrothers类由Team类继承而来。用HuluWa类的数组覆盖了Team类里Creature类的数组。并增加了一些葫芦娃之间排序的接口。
* 同时重写覆盖了排阵接口，以方便对HuluWa类的对象进行排阵。

### BattleField类
* BattleField类里有一个TwoDimensionSpace类space，一个Team类monsters，一个HuluBrothers类huluBrothers。在main函数里通过操控monsters和huluBrothers来进行阵型变换，形成对峙局面。