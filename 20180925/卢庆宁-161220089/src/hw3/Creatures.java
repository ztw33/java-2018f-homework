package hw3;

class Creatures {						//生物群类
	protected int number;					//生物数量
	protected Creature[] cs;				//生物类数组
	protected Formation f;
	Creatures(){}							//空的默认构造函数，在子类中具体实现
	public int getNumber() {return number;}	//获取生物数量
	public String getFormationName(){return f.name;}
	public int set(Board b,int x,int y,Formation f) //根据阵型放置生物群
	{
		if(f.test(b,x,y,number)==false)
		{
			f.set(b,x,y,cs,number);
			this.f=f;
			return 0;
		}
		else return -1;
	}
	public void reset(Board b)				//重置当前生物群
	{
		for(int i=0;i<number;i++)
		{
			b.reset(cs[i]);
		}
	}
	public void upset(int i) {}
	public void sort() {};
}

class CalabashBrothers extends Creatures {	//葫芦娃群类
	CalabashBrothers(int k)						//默认构造函数
	{
		number=k;
		cs=new CalabashBrother[7];
		for(int i=1;i<=number;i++) 
		{
			cs[i-1]=new CalabashBrother(i,0,0);
		}
	}
	public void upset(int time)					//打乱葫芦娃队列
	{	
		java.util.Random random=new java.util.Random();
		for(int j=0;j<time;j++)
		{
			for(int i=0;i<=6;i++)
			{
				int iRandom = random.nextInt(7);
				Creature temp=cs[iRandom];
				cs[iRandom]=cs[i];
				cs[i]=temp;
			}
		}
	}
	public void sort()							//对葫芦娃队列排序
	{
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<6-i;j++)
			{
				if(cs[j].getNumber()>cs[j+1].getNumber())
				{
					Creature temp=cs[j];
					cs[j]=cs[j+1];
					cs[j+1]=temp;
				}
			}
		}
	}
}

class Monsters extends Creatures {				//妖怪群类
	Monsters(int number)							//默认构造函数，数组首项具体化为蝎子精
	{
		this.number=number;
		cs=new Creature[number];
		cs[0]=new ScorpionMonster(0,0);
		for(int i=1;i<number;i++)
		{
			cs[i]=new SmallMonster(0,0);
		}
	}
}
