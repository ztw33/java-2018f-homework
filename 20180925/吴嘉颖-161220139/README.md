# 史诗巨制悬疑历史动作大片——Battle

-----------------------------------------
## 一、 剧情

1. 葫芦七兄弟初始乱序->按长蛇阵依序排队
2. 蝎子精带领小喽啰按阵型站队
3. 二者上战场，老爷爷与蛇精各自呐喊助威
4. 显示战场的对峙局面
5. 蝎子精阵列变阵，重复3-4

----------------------------------------------------
## 二、 人·景·物分析

### 1. 大戏开幕，演员有谁？

葫芦七兄弟、蝎子精&小喽啰、老爷爷、蛇精
他们均有姓名、阵营、在战场上的位置等共同属性，以Creature类将其囊括：
```java
	class Creature {
		String CName;
		private Factions factions;
		private int placeR, placeC;
		char sign;
		...
	}
```
为方便打印战场，还为每个人设置了标记。

葫芦兄弟还需要排序，所以有些额外的属性（如顺序seq等），因此定义CalabashBro类：
```java
	class CalabashBro extends Creature {
		private Color color;
		private int placeInQue;
		private int seq;
		...
	}
```

为方便起见，还定义两个需要摆阵型的队列：
```java
	class CBQueue implements CreatureQueueBehaviors {
		List<CalabashBro> broQueue;
		...
	}
	
	class VillainQueue implements CreatureQueueBehaviors {
		private List<Creature> vlQueue;
		int numTotal, numOnField;
		...
	}
```
方便他们排序、摆好阵型，直接打包上战场。

- - - - - - - - - - - - - - -
### 2. 战场布置，上板砖！

两方对战，当然需要一个荒凉、壮阔的战场——BattleField，
而战场上，各方人员需要站位，直接站在黄土上不太好分配位置，给他们几块板砖垫垫脚——
```java
	class Brick<T> {
		char sign;
		T holder;
		...
	}
```
为了方便输出显示战场，每一块砖内都设了一个标记，需要时直接输出即可。而T holder则为板砖上站的T类型事物（如Creature）的引用。

这样，战场上就有了砖：
```java
	class BattleField{
		int row, col;
		Brick<Creature>[][] bricks;
		...
	}
```

有了砖，才能有人，有了人，剧情才能继续跑下去……
然后，才有了史诗巨制悬疑历史动作大片——Battle：
```java
	public class Battle {
		private static final int N = 20;
		static private BattleField field;
		...
	}
```
（剧组穷啊，意思意思铺个20*20板砖就算了……

- - - - - - - - - - - - - - -
### 3. 辅助设备1——先别打！等我先排个序！

蝎子精：这还打不打了！
葫芦娃：大兄dei！稍等片刻！等我召唤个排序器——
```java
	class Sorter {
		private SortAlg alg;
		...
	}
```
自带排序算法引擎！只要998！排序器带回家！（详情请见作业二）

- - - - - - - - - - - - - - -
### 4. 辅助设备2——小喽啰生成器，流水线生产，你值得拥有

在反派队列 VillainQueue 中，蝎子精诞生后，还得一只一只地生成小喽啰，实在是太麻烦了，因此——

先来一个囊括万物的生成器：
```java
	interface Generator<T> {
	    T next();
	}
```

再来一个小喽啰生成器，直接设定好各种参数（名字、阵营、标记）：
```java
	class underlingsGenerator implements Generator<Creature>{
	    public Creature next()  {
	        return new Creature("小喽啰", Factions.EVIL, 'v');
	    }
	}
```

要批量生产，还需要一个能够实现流水生产的生成器：
```java
	class Generators {
    	static <T> void fill(Collection<T> clt, Generator<T> gen, int num){...}
	}
```

这样，在蝎子精进入队伍后，只需要一句
```java
	Generators.fill(vlQueue, new underlingsGenerator(), n-1);
```
即可实现小喽啰的批量生产、批量入队了。

- - - - - - - - - - - - - - -
### 5. 阵型预设

两方对战，大阵摆上，阵型当然要预先想好，可定义一个枚举类型直接列举，内置boolean数组直接映射阵型：
```java
	enum Formation {
		OVEREDGE("鹤翼",1), ECHELON("雁行",2), YOKE("冲轭",3), HYDRA("长蛇",4),
		SCALE("鱼鳞",5), SQUARE("方円",6), HOOKEDSPEAR("偃月",7), ARROW("锋矢",8);

		String Cname;
		boolean[][] form;
		int num;
		...
	}
```

----------------------------------------------------
## 三、 剧本分析

### 1. 葫芦七兄弟排序

葫芦七兄弟还是需要乱站+排序，所以可以基本沿用作业二的设定（葫芦娃、葫芦娃队列、排序器、排序算法...），此处不再赘述。

- - - - - - - - - - - - - - -
### 2. 两队列按阵型上战场、变阵 & 老爷爷、蛇精上战场
 
对于该类情节，均有个人踏上战场的部分，而变阵也可以视为下战场-摆好阵型-再上战场的行为，因此**踏上战场（的某块砖）、离开战场（的某块砖）**均可视为生物的共有行为——
```java
	class Creature {
		...
		void stepOn(BattleField field, int r, int c) {...}
		void leave(BattleField field){...}
	}
```

对于踏上某块砖，可表示为：
	- 将这块砖的位置记录在自己的位置信息中
	- 将这块砖打上自己的标记
	- 将这块砖与自己建立联系（砖中的holder引用指向自己）
	
而对于离开某块砖，则可表示为：
	- 修改自己的位置信息
	- 擦除这块砖上自己的标记，修改为无人标记
	- 擦除这块砖与自己的联系（砖中的holder引用置空）
	
- - - - - - - - - - - - - - -
而对于两个阵列的上战场，为整体行为，可以设置好阵型，一下子跳上战场：
```java
	class VillainQueue implements CreatureQueueBehaviors {
		...
		void JumpOntoField(BattleField field, Formation form){...}
		void leaveField(BattleField field) {...}
	}
	
	class VillainQueue implements CreatureQueueBehaviors {
		...
		void JumpOntoField(BattleField field, Formation form){...}
	}
```

其中，JumpOntoField为对战双方在战场上的共同行为——因此，将这共同行为作为一种行为规范/接口，具体实现由双方各自决定：
```java
	interface CreatureQueueBehaviors {
	    void JumpOntoField(BattleField field, Formation form);
	}
```

JumpOntoField具体实现时，还是按照阵型的映射，一个一个依次 stepOn 战场。

- - - - - - - - - - - - - - -
### 3. 战场显示
由于每一块砖都设置好标记，显示战场时直接输出就好啦：
```java
	class BattleField{
		...
		void ShowField() {...}
	}
```

-----------------------------------------------------------

### 由此，以'public class Battle'为舞台，双方对阵，风云变幻……

-----------------------------------------------------------
## 四、 总结与心得

1. 曹老师曰：面向对象编程，是反映现实世界的，写代码像画动画片一样……
2. 运用曹老师的“动画片思想”，编程时，从“创世者”的角度考虑——
在一场战争中，我需要new一个BattleField，BattleField上有Brick，Brick上面可以站Creature，Creature有很多种，大家都可以stepOn战场、leave战场，需要摆阵型时，还可以直接先排排坐，~~吃果果~~一个一个摆好位置再JumpOntoField，一步一步细化下去。
3. 对于某些类，若有共同的属性、行为，可提取共同点，先定义基类，而这些类则可作为子类定义。关于抽象-封装-继承-多态的概念，需在实践中不断加深理解。
4. 关于Colletion： 结合泛型指定容器中的对象类型，可自动调整大小。留心List, Set, Queue和Map的特点及其各种实现的区别、iterator的应用。
5. 关于Generics： 泛型可运用于类、接口、方法。注意java中的泛型与c++中模板的区别——java中泛型使用擦除实现，使得运行时具体的类型信息因被擦除而无法获得，而擦除的补偿包含类型标签的传递、工厂化方法、强制转型（数组）等。另外，还需注意泛型的边界与通配符问题——注意赋值两边的object是否类型对等（be type-equivalent to）的。