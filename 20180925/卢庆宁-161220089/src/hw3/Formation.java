package hw3;

class Formation {			//阵型类，含测试、放置等方法
	public String name;
	Formation(){name="无";}
	public boolean test(Board b,int x,int y,int number) {return true;}
	public void set(Board b,int x,int y,Creature c[],int number) {}
}

class Snake extends Formation {
	Snake(){name="长蛇";}
	public boolean test(Board b,int x,int y,int number)
	{
		boolean res=false;
		for(int i=0;i<number;i++)
		{
			res=res||b.test(x+i, y);
		}
		return res;
	}
	public void set(Board b,int x,int y,Creature c[],int number)
	{
		for(int i=0;i<number;i++)
		{
			c[i].set(x+i, y);
			b.set(c[i]);
		}
	}
}

class Goose extends Formation {
	Goose(){name="雁行";}
	public boolean test(Board b,int x,int y,int number)
	{
		boolean res=false;
		for(int i=0;i<number;i++)
		{
			res=res||b.test(x+i,y-i);
		}
		return res;
	}
	public void set(Board b,int x,int y,Creature c[],int number)
	{
		for(int i=0;i<number;i++)
		{
			c[i].set(x+i, y-i);
			b.set(c[i]);
		}
	}
}

class Yoke extends Formation {
	Yoke(){name="冲轭";}
	public boolean test(Board b,int x,int y,int number)
	{
		boolean res=false;
		for(int i=0;i<number;i++)
		{
			int j=i%2==0?0:-1;
			res=res||b.test(x+i, y+j);
		}
		return res;
	}
	public void set(Board b,int x,int y,Creature c[],int number)
	{
		for(int i=0;i<number;i++)
		{
			int j=i%2==0?0:-1;
			c[i].set(x+i, y+j);
			b.set(c[i]);
		}
	}
}

class Crane extends Formation {
	Crane(){name="鹤翼";}
	public boolean test(Board b,int x,int y,int number)
	{
		boolean res=false;
		int i=0;
		for(;i<=number/2;i++)
		{
			res=res||b.test(x+i, y-i);
		}
		for(;i<number;i++)
		{
			res=res||b.test(x+number-1-i, y-i);
		}
		return res;
	}
	public void set(Board b,int x,int y,Creature c[],int number)
	{
		int i=0;
		for(;i<=number/2;i++)
		{
			c[i].set(x+i, y-i);
			b.set(c[i]);
		}
		for(;i<number;i++)
		{
			c[i].set(x+number/2+number/2-i, y-i);
			b.set(c[i]);
		}
	}
}