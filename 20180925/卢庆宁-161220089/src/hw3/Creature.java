package hw3;

class Creature {							//生物体类
	protected boolean exist;					//存在情况
	protected String name;						//名称
	protected int x;							//行坐标
	protected int y;							//列坐标
	protected char ch;							//字符表示
	Creature(){exist=false;ch=' ';}								//默认构造，令存在为false
	public boolean getExist() {return exist;}					//获得四个保护变量的值
	public String getName() {return name;}
	public int getX() {return x;}
	public int getY() {return y;}
	public char getCh() {return ch;}
	public int getNumber() {return 0;}
	public void set(int x,int y) {exist=true;this.x=x;this.y=y;}//放置生物
}

class CalabashBrother extends Creature {	//葫芦娃类
	private int number;
	CalabashBrother(int i,int x,int y)
	{
		set(x,y);
		ch=(char)(i + '0');
		number=i;
		switch(i)
		{
		case 1:name="大娃";break;
		case 2:name="二娃";break;
		case 3:name="三娃";break;
		case 4:name="四娃";break;
		case 5:name="五娃";break;
		case 6:name="六娃";break;
		case 7:name="七娃";break;
		}
	}
	public int getNumber() {return number;}
}

class GrandFather extends Creature {	//爷爷类
	GrandFather(int x,int y)
	{
		set(x,y);
		this.name="爷爷";
		this.ch='0';
	}
	public void cheer() {};
}

class ScorpionMonster extends Creature {//蝎子精类
	ScorpionMonster(int x,int y)
	{
		set(x,y);
		this.name="蝎子精";
		this.ch='$';
	}
}

class SnakeMonster extends Creature {	//蛇精类
	SnakeMonster(int x,int y)
	{
		set(x,y);
		this.name="蛇精";
		this.ch='S';
	}
	public void cheer() {};
}

class SmallMonster extends Creature {	//小喽啰类
	SmallMonster(int x,int y)
	{
		set(x,y);
		this.name="小喽啰";
		this.ch='o';
	}
	public void cheer() {};
}
