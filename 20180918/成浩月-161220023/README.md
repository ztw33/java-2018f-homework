# 改进后的葫芦兄弟_V3

----

## 主要思想

> * 分为两个大类，葫芦兄弟队列，排序
> * 葫芦兄弟队列类CalabashBrothers类内定义葫芦娃的枚举类型CalabashBrother，该枚举类型将葫芦娃的排行和颜色属性绑定在一起，可以'talk'其排行，颜色。葫芦娃有且仅有互不相同的7只。葫芦兄弟队列类维护一个静态的有7个葫芦娃的私有队列，将构造函数定义为私有函数，并且通过其他函数返回这个7个葫芦娃的队列，确保葫芦娃有且仅有互不相同的7只，并且只能在队列类内部修改葫芦娃之间的站队。队列类负责指挥葫芦兄弟两两交换，报数，对葫芦兄弟比较大小等
> * 排序大类有三个类，冒泡排序，二分排序，随机化排序，它们都实现接口Sort。

-----

### 葫芦兄弟队列类

> 葫芦娃的枚举类型：该枚举类型在葫芦兄弟队列类内部定义，不需要为外界所使用
>
> ```队列类在创建对象时就要初始化7个葫芦娃，这个数量应该要不允许更改，单个葫芦娃也不允许外界更改。因为是葫芦娃队列，让葫芦娃按照指令进行移动、报数、报告位置更改、比较两个葫芦娃的大小顺序是这个类该有的方法。
> enum CalabashBrother{
> 		FIRST("老大","红色"),SECOND("老二","橙色"),THIRD("老三","黄色"),FOURTH("老四","绿色"),FIFTH("老五","青色"),SIXTH("老六","蓝色"),SEVENTH("老七","紫色");
> 		private String status;
> 		private String color;
> 		
> 		CalabashBrother(String status,String color){
> 			this.status=status;
> 			this.color=color;
> 		}
> 		public void tellstatus() {}
> 		public void tellcolor() {}
> 	}
> ```
>
> 队列类在创建对象时就要初始化7个葫芦娃，这个数量应该要不允许更改，单个葫芦娃也不允许外界更改。让葫芦娃按照指令进行移动、报数、报告位置更改、比较两个葫芦娃的大小顺序是这个类该有的方法。
```java
public static final int number=7;
private static CalabashBrother[] cala=new CalabashBrother[number];  //私有静态葫芦娃队列
private CalabashBrothers() {              //私有构造函数，不允许创建该类对象，初始化葫芦娃队列
		for(int i=0;i<number;i++)
			cala[i]=CalabashBrother.values()[i];
}
private static CalabashBrothers c=new CalabashBrothers();   //此类的私有静态对象
static CalabashBrothers GetCalabashBrothers();              //返回这个静态对象
public void swap(int i,int j);      //交换两个葫芦娃
private void tellmove(int x,int y); //报告位置的移动
public boolean larger(int i,int j); //比较两个葫芦娃的大小
public void countoffbystatus();     //按照排行报数
public void countoffbycolor();      //按照颜色报数
```

----
### 排序类

> 这个大类应该实现指挥葫芦娃如何移动、如何排序的功能。冒泡法排序、二分法排序、随机化占位都具有指挥葫芦娃移动的功能。将这个特性抽象出来作为一个interface Sort,三个类分别implements Sort来具体实现排序的功能。

```java
interface Sort{
	public void sort(CalabashBrothers c);
}
class BubbleSort implements Sort{...}

class BinarySort implements Sort{...}

class Randomize implements Sort{...}
```
