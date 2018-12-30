 # 面向葫芦娃编程3 #
 ***
   ###### 实现两个阵营的阵型变换 ######

***
## 生物
包括葫芦娃 爷爷 蛇精 小喽啰 蝎子精
```
class Creature
{ 
	String name;  
	Position pos;
  	void OutPutInfo()
  	...
}
```
 Creature作为CalabashBrother, Monster类的基类
```
class Monster extends Creature { ... }
class CalabashBrother extends Creature { ... }

```
***
## Team类
```
abstract class CreatureTeam
{
	protected Creature[] list;
	protected Creature cheerleader;
	
	protected abstract void GetRandomList();
	public abstract void SetRandomFormation(Field field);
}
```
包含有成员表，助威者和获取随机列表，随机阵型的方法
作为CalabashBrotherTeam 和 MonsterTeam 的基类
```
class MonsterTeam extends CreatureTeam { ... }
class CalabashBrotherTeam extends CreatureTeam { ... }
```

***
## 阵型
阵型数量有限，使用枚举类描述
```
enum  FormationTye
{
	ChangSe(Pos(0, 0), Pos(1, 0), Pos(2, 0), Pos(3, 0), Pos(4, 0), Pos(5, 0), Pos(6, 0)),
	HeYi(Pos(0, 0), Pos(1, 1), Pos(2, 2), Pos(3, 3), Pos(4, 2), Pos(5, 1), Pos(6, 0))；
	
	private Position list[];
	...
}
```
- 由构造器将位置信息保存至list
- 这里的信息只记录了各点与list[0]的相对位置，可根据list[0]的绝对位置改变阵型位置

```
	public static Position[] GetRandomFormation()
	{
		int random = (int)(Math.random()* FormationType.values().length);
		return FormationType.values()[random].GetList(); //返回相对位置列表
	}
```

***
## Field
```
public class Tile
{	
	private Creature CreatureStandOn;
	private boolean IsEmpty;

 	boolean Set (Creature src) { ... };
 	boolean Clear() { ... };
 	void Print() { ... };
 	...
 }
 ```
 Tile类是一个生物可站的位置 
 ```
 class Field
 {
 	private Tile[][] plant;
 	public boolean Set (Creature creature, int x, int y);
 	public boolean AllClear();
 	...
 }
```
Field类包含一个Tile的二维数组作为战场，有安防生物，清空等方法
***
![在这里插入图片描述](https://github.com/foreveryounth/java-2018f-homework/blob/master/20180925/%E5%91%A8%E6%98%8C%E8%B1%AA-161220178/img-floder/%E7%BB%93%E6%9E%84%E8%AF%B4%E6%98%8E.png)                                                                                                                                     
***
