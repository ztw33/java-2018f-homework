# java 第三次课后作业

## 本次code用到的OOP思想
> <font size=4 face='微软雅黑'>1. 葫芦娃改用enum进行定义而不是class，限制了其数量。  
<code>
<pre>
<code class='java'><font size=4 >
//用枚举类型定义七个葫芦娃
enum Calabash implements printinfo{
	//实例化
	Red("红色","老大",1),
	Orange("橙色","老二",2),
	Yellow("黄色","老三",3),
	Green("绿色","老四",4),
	Cyan("青色","老五",5),
	Blue("蓝色","老六",6),
	Purple("紫色","老七",7);
	......
}
</pre>
</code>
> <font size=4 face='微软雅黑'>
> 2. 数量不定的类型(小喽啰和空缺)以及数量确定的类型(蝎子精、蛇精和老爷爷都只有  
> 一个)有不同的构造方法，如:  
<pre><code class='java' ><font size=4 >
//空缺位置  
class Blank implements printinfo{  
	private char sym='-';  
	@ Override  
	public void printout() {  
		System.out.print(sym);  
	}  
}  
</code>
</pre>
<pre><code class='java'><font size=4 >
//蛇精
class Snack implements printinfo{
	<b>public static Snack snack=new Snack();</b>
	private char sym;
	private Snack() {
		this.sym='&';
	}
	@ Override
	public void printout() {
		System.out.print(sym);
	}
}
</code></pre>
> 加粗部分的代码保证蛇精的对象有且仅有一个。  
> 3. 使用了printinfo()接口，并在不同类型中对该接口进行Override，实现不同类型的  
> 数据共同的操作。  
<code>
<pre>
<font size=4 >
//打印信息的接口
<b>interface printinfo</b>{
	void printout();
}
enum Calabash <b>implements printinfo</b>{
	......
	@ Override
	public void printout() {
		System.out.print(this.rank);
	}
	
}
//小喽啰类(数量不定)
class Monster <b>implements printinfo</b>{
	......
	@ Override
	public void printout() {
		System.out.print(sym);
	}
}
......
</pre></code>
## 程序运行说明
> <font size=4 face='微软雅黑'>
> 1. shape_list.txt为阵型配置文件,'v'表示小喽啰,'%'表示蝎子精。请将该配置文件和代码文件HW3.java放在同一个目录下执行。</br>
> 2. 输出结果中'-'表示该位置空缺,'v'表示小喽啰,'%'表示蝎子精,'&'表示蛇精,'o'表示老爷爷,数字1-7分别代表排行为对应数字的葫芦娃。</br>
> 3. 程序运行后按控制台提示进行输入即可。</br>
<code>
<pre>
当前阵型: 衡轨
--------------------
-----------v--------
---------v----------
-----------v--------
---------v----------
-----------v--------
---------v----------
-----------%--------
--------------------
----&---------------
---------1----------
o--------2----------
---------3----------
---------4----------
---------5----------
---------6----------
---------7----------
--------------------
--------------------
--------------------
输入change变换1次阵型,或输入数字n变换n次阵型,输入end结束...
end
结束
</code>
</pre>