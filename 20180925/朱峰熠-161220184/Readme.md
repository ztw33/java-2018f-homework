# **面向葫芦娃编程**

## 类的划分


### 生物类

#### Creature
    public class Creature {
    	Creature(){;}
    	Creature(String name, int camp, int id, char symbol){
   		 ...
    }
    	public int camp;		//阵营
    	public int indentity;	//身份
    	public String name;		//姓名
    	public char symbol;		//符号
    	public int sitex;		
    	public int sitey;		//坐标
	......
    }
Creature类是所有生物类的基础，包含了所有生物的共同点，实现了说出自己名字，说出自己符号，移动到某一坐标，交换坐标等基础功能。
#### CalaBrothers

    public class CalaBrothers extends Creature{
		CalaBrothers(int rank,String color,String name,char symbol){
		...
	}
		private  int rank;
    	private  String color;
    	public int site;
    	public static CalaBrothers CalaBros[] = new CalaBrothers[7];
	......
	}
CalaBrothers类继承了生物类，多出了排名，颜色等信息，同时在内部生成static型的葫芦娃信息，添加了说出颜色的功能。

葫芦兄弟的符号为1到7数字。
#### Monster
    public class Monster extends Creature{
    	Monster(String name, char symbol){
		...
	}
		public static Monster Mice[]= new Monster[9];
    	public static Monster Scorpion = new Monster("Scorpion",'%');
	}
Monster类继承了生物类，暂时没有新的特征数据，仅在内部生成了新的Monster,即九只老鼠和一个蝎子精。

蝎子精符号为%，老鼠们都为#。
#### Commander
	public class CommanderCalabro extends Creature{...}
	public class CommanderMonster extends Creature{...}
Commander类下有两个分支类，分别为葫芦娃的指挥官和怪物的指挥官，生成了爷爷和蛇精两个对象，内部实现了选择阵法，指挥布阵的函数。

布阵函数的调用方式为输入阵型名称和阵型中心点的位置。

爷爷符号为@，蛇精为$。
### 地图类

#### Map
	public class Map {
	    public static Creature LandCreature[][] = new Creature[15][15];
    	private static Creature EmptyCreature = new Creature("none",Global.EMPTY,0,' ');
    	
		Map(){;}

		public static void SetSite(Creature anyone,int x, int y)；
		public static void PrintMap()；
	}
Map类内部生成了一个全局共享的15*15的地图方阵，实现了将某个坐标设置为某个生物的功能和输出全图信息的功能。。

### 阵型类

#### Formation
	public class Formation {
    	public String name;
    	public int relationX[];
    	public int relationY[];
		
		Formation(String name,int rx[],int ry[]){...}

		static int []rx1 = new int[]{1,1,2,2,3,3,4,4};
    	static int []ry1 = new int[]{1,-1,2,-2,3,-3,4,-4};
   	 	public static Formation Crane = new Formation("Crane",rx1,ry1);//鹤
		......
	}
阵型类保存了阵型的名字以及除中心节点以外，其他阵型节点的位置信息。在类中初始化了8个阵型的信息。
###系统类

####Global
	public class Global {
    	public static final int EMPTY = 0;
    	public static final int MONSTER = 1;
    	public static final int CALABROS = 2;
    	public static final int COMMANDER = 0;
    	public static final int LEADER = 1;
    	public static final int NORMARL = 2;
	}
Global类保存了一些全局变量，方便使用，避免矛盾。
#### Instructor
	public class Instructor {
    Instructor(){

        CalaBrothers.Init_Array_Bros();
        Monster.Init_Mice();
        Map.Init_Map();
	}

		public void GetRandomArray();
		public void Bubble_Sort()；
		public void Binary_Sort()；
    }
Instructor类中定义了一些全局使用的函数(暂时只为获取随机数列以及排序),同时调用一些类中的初始化函数。
#### God
	public class God {
    public static final void main(String []args){
        Instructor instructor = new Instructor();

        CommanderCalabro.Grandpa.SetFormation_CalaBros(Formation.Snake,3,3);
        CommanderMonster.Serpent.SetFormation_Monster(Formation.Crane,8,6);
        Map.PrintMap();

        CommanderMonster.Serpent.SetFormation_Monster(Formation.Bow,8,6);
        Map.PrintMap();

        CommanderMonster.Serpent.SetFormation_Monster(Formation.Scale,8,6);
        Map.PrintMap();
    }
}
God类指挥全部类的行为，是一切的开端。
## 运行过程
从God类中的main函数开始，初始化数据。

爷爷发出指令，在大娃带领下，将葫芦娃排为一字长蛇阵。

蛇精发出指令，在蝎子精带领下，老鼠们排为鹤翼阵。



蛇精发令变阵，在蝎子精带领下，老鼠们排为锋矢阵。

蛇精发令变阵，在蝎子精带领下，老鼠们排为鱼鳞阵。

每次怪物摆阵，打印地图信息。
## 后续目标
1.更改输出方式，当前方式不够明显，不够美观

2.添加类Commander，让当前两个指挥官类继承它，思考他们可以合并的方式方法

3.添加Creature类的数据，如生命值，攻击力等，继而实现简单的战斗系统

4.思考是否有抽象的部分可以封装成新的类或接口，尝试分包

5.使用UML，构建类图等建模图表

6.简化代码，优化结构
