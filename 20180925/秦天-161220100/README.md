# 设计理念
## 万物皆对象
- 作战双方是一类共同对象Troop的两种特殊形式，分别抽象为类CalabashSide和MonsterSide的对象。
- 人员都是生物体，都有名字等，抽象为虚类Creature的虚子类Fighter和Audience，具体又由之继承为CalabashBrother、SmallMonster等。
- 作战场地抽象为BattleField。
- 整场战斗作为一个抽象概念，抽象为类Battle。
- 具体类间关系见UML类图：
![UML](
        https://github.com/Qcer17/java-2018f-homework/blob/master/20180925/%E7%A7%A6%E5%A4%A9-161220100/UML.png
      )
# 面向对象机制
## 封装
### 实例
- BattleField类表示战场，其中对外隐藏了表示战场的变量board和表示战场大小的变量n，只对外提供addObject和removeObject等方法进行人员配置、战场信息获取等功能。
```java
	private int n;
	private char[][] board;
```
- Creature类表示生物，其中对外隐藏坐标变量x，y，名称变量name，只对外提供获取这些属性的接口。
```java
	private int x=-1,y=-1;
	private char name;
```
- Troop类表示军队，其中对外隐藏了士兵、观众以及他们的移动方法等，只对外提供阵型变化操作。
```java
	private void soldierMove(int id,BattleField battleField,int x,int y);
	private void audienceMove(BattleField battleField,int x,int y);
```
### 优点
- 隐藏了内部属性，保护了内部状态，增强了安全性。
- 类对外接口提供操作的内部实现可以进行更改，而不对外部产生影响，增强了可维护性。
## 继承
### 实例
- 认为葫芦娃方和妖怪方分别是一种特殊的军队，军队有士兵和观众，并且能够进行阵型变换。类CalabashSide和MonsterSide继承了类Troop，并且成员soldiers和audience访问控制设置为protected，以便于子类操作，同时也起到对外隐藏这两个变量的作用，在两个子类中分别添加不同的构造函数以创建各自的士兵和观众。
```java
	class Troop{
		protected Creature[] soldiers;
		protected Creature audience;
		public void snakeFormation(BattleField battleField,boolean left){...}
		...
	}
	class CalabashSide extends Troop{
		...
	}
	class MonsterSide extends Troop{
		...
	}
```
### 优点
- 易于代码复用，不必再为CalabashSide和MonsterSide分别实现功能相同的对外方法。
- 为多态创造了条件。
## 多态
### 实例
- Battle类代表一场战斗，成员变量包括作战双方troops、场地battlefield，成员方法包括对某一方下达阵型变换命令changeFormation和展示对峙情况show。其中，troops为Troop类型的数组，数组中的引用分别指向CalabashSide和MonsterSide类型的变量，从而在下达变换命令时不需要对二者进行区分。
```java
	public class Battle {
		Battle(int n,int numMonsters){
			...
			troops[0]=new CalabashSide();
			troops[1]=new MonsterSide(numMonsters);
		}
		public void changeFormation(boolean side, String formationName) {
			...
			troops[id].snakeFormation(battleField, side);
			...
		}
		...
	}
```
### 优点
- 可以用基类的方法接口调用子类的方法，增强了可复用性。
- 把派生类对象视作基类对象，可以屏蔽不同派生类对象之间的差异，写出通用的代码，以适应变化的需求。

