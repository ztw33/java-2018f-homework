
# Creature生物体

```src/creature //该package中含所有生物体```

```public class Creature { ... }```

Creature类作为所有生物体类的父类，拥有名字属性，还有一个“移动”的功能，即走到地图上的相应位置。

生物体包含：
- 葫芦娃（'&'表示）
- 爷爷（'#'表示）
- 蝎子精（'$'表示）
- 小喽啰（'*'表示）
- 蛇精（'@'表示）

其中，葫芦娃的实现基本与作业二中相同。但enum不能使用继承，因此不再采用枚举方式构造单个葫芦娃。使用CalabashBody类来继承Creature，描述一个葫芦娃。再利用一个CalabashBrother类，封装起七兄弟，进行排队等操作：

```class CalabashBody extends Creature {}```

爷爷和蛇精都可以进行加油助威，因此使用一个接口Cheer：

```public interface Cheer { public void cheer() {} }```

```public class GrandFather extends Creature implements Cheer { }```

小喽啰简单继承了父类，通过“小喽啰+编号”的形式设置名字。蝎子精还有一个“带领”功能，但因为只有其一人拥有，不再设置接口。

# Formation阵法

```src/formation //该package里面包含各种阵法```

```public abstract class Formation { ... }``` 

设置一个抽象类Formation，有名字属性，还有使每个阵型都有“形成阵型”和“解散阵型”两个功能。每个阵型的具体功能是在给定队首的坐标下，排成或解散相应图形的阵型，实现离不开Creature中的move功能。

# Map地图

```src/map //该package里包含完整的地图信息```

```public class Position { }```

Position表示地图上的某一位置，具有横纵坐标的属性，还可以放置任一生物体。

```public class Map { }```

Map表示整个地图，含有一个Position的二维数组，使得各类生物可以放置在地图上任何位置。考虑到所有生物体都会在此地图上排兵布阵，因此该类中还含有一个CalabashBrother的对象，GrandFather、SnakeMonster、SorcpionMonster的对象各一个，一个Minion的数组。

在Map中调用main函数，思路是创建Map对象，创建某一阵型的对象，将map中的某些生物体和位置信息传入阵型中，阵型可以将生物体放在指定位置上，最后简单利用符号对地图进行打印。