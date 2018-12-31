#java-homework3- 说明:

####在面向对象思想的指导下，整个程序包含的类可以分为三大类：战场，阵营和生物。每个大类又具体划分如下：

##1. 战场：
###class BattleFeld，  class Block: 
- BattleField是整个战场的抽象，主要的成员变量是一个 NxN 的 Block 类型二维数组
- 战场上的每一个地块都是 Block 类的一个对象。 每个Block包含一个Organism(生命体)的成员对象

##2. 阵营：
###Interface Formations:
- 声明了7个阵型所对应的函数。将Formations单独抽象成一个接口是考虑到日后葫芦娃阵营和蛇蝎精阵营都需要实现这7个阵型，但具体实现的代码却不一定一样。
- ##abstract class Group implements Formations
- 阵营的一个抽象类，是Heros类和Monster类的父类, 由于实现了接口Formations, 又是一个抽象类，所以他的子类Heros和Monster必须给出Formations的具体实现。

###class Heros, Monster extends Group
- Heros和Monster都是Group的一个子类，分别代表了两个阵营。 Heros中包含爷爷和7个葫芦娃， Monster中包含蛇精，蝎子精和数量可变的喽啰。 两个类分别给出Formations的具体实现 (目前Heros类只写了蛇形阵的具体实现，其他阵型为空)。
##3. 生物:
###abstract class Organism
- 所有生命体(包括葫芦娃, 爷爷, 蛇蝎精, 喽啰)的父类, 其中包含了一个成员对象Block position表示当前的生命体所处的位置, 以及一个函数moveTo(Block b), 用于生命体的移动。
###class Gourd extends Organism
- 葫芦娃类。在homework2中使用了enum来定义葫芦娃， 但这里为了要让葫芦娃能继承父类Organism， 我将葫芦娃的枚举类型包装成了一个类， 枚举类型在类中定义且是每个对象的一个成员对象


		public class Gourd extends Organism {
			public enum enum_Gourd {
	  	    	RED("老大", "赤", 0), ORANGE("老二", "橙", 1), YELLOW("老三", "黄", 2),
	  	    	GREEN("老四", "绿", 3), CYAN("老五", "青", 4), BLUE("老六", "蓝", 5), PURPLE("老七", "紫", 6);
	   			private String name, color;
	    		private int rank;
	 
	        	enum_Gourd(String name, String color, int rank) {
	            	this.rank = rank;
	            	this.name = name;
	            	this.color = color;
	        	}
	
	    	}
   			private enum_Gourd gourd;
			//构造函数
			Gourd(int rank){
       		 	gourd = enum_Gourd.values()[rank];
    		}
			...
###class Grandpa, Scorpion, Serpent
- 这三个类比较类似，都是单例对象并且需要继承父类Organism。仿照葫芦娃类的设计方法， 在类内部定义了一个枚举对象来满足上述要求。

###class Minion extends Organism
- 喽啰不需要单例，因此只是一个普通的类，可以创建无数个对象

 

##main函数执行过程：
- 创建一个BattleField类的对象 battlefield.
- 创建Heros类和Monster类的对象 heros 和 monsters
- heros摆蛇形阵， 用户指定monsters可以任意摆7个阵型之一。
- 每个阵型中爷爷和蛇精的位置都在阵型函数中确定。

##一些思考:
1. 在类的内部定义枚举类型，虽然可以让这个类既能继承父类，又具有枚举类型的特性，但总感觉有些违和。 java中枚举类型为什么不允许继承父类？如果仅仅是因为每个枚举都已经继承了Enum这个类型，而java又不允许多继承，在我看来这像是语言的一个bug。 如果不仅仅是这样的话，是否有原则上的原因使得java不允许枚举类型继承父类？比如这样做违反了面向对象的某个原则？
2. 7个葫芦娃在程序中都是单例的，有各自的内存区域，那么能不能让他们有各自的函数呢？比如每个葫芦娃都有一个技能，这些技能应该是和对象绑定的，不属于自己的技能应该不能使用。如何实现这样的功能？