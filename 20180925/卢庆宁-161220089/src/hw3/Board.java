package hw3;

class Board {
	private int height,width;		//棋盘的高度和宽度
	private Creature c[][];			//每个格子放一个生物
	Board(int h,int w)				//默认构造函数
	{
		height=h;
		width=w;
		c=new Creature[height][width];
		init();
	}
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public void testAndSet(Creature c)			//检测给定坐标并放置生物
	{
		if(test(c.getX(),c.getY())==false) this.c[c.getX()][c.getY()]=c;
	}
	public void set(Creature c) {this.c[c.getX()][c.getY()]=c;}					//直接放置给定生物
	public void reset(Creature c) {this.c[c.getX()][c.getY()]=new Creature();}	//将给定生物从棋盘上撤销
	public boolean test(int x,int y)			//检测给定坐标	
	{
		if(x<0||x>=height||y<0||y>=width) return true;
		else return c[x][y].getExist();
	}
	public void init()							//棋盘回到初始状态
	{
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				c[i][j]=new Creature();
			}
		}
	}
	public char getCh(int x,int y){ return c[x][y].getCh();}	//获得给定坐标的生物种类
	public void showAll(Display disp)			//打印当前棋盘的情况
	{
		for(int j=0;j<width+2;j++)
		{
			//System.out.print("#");
			disp.setLog("#");
		}
		//System.out.print("\n");
		disp.setLog("\n");
		for(int i=0;i<height;i++)
		{
			//System.out.print("#");
			disp.setLog("#");
			for(int j=0;j<width;j++)
			{
				//System.out.print(getCh(i,j));
				disp.setLog(""+getCh(i,j));
			}
			//System.out.print("#\n");
			disp.setLog("#\n");
		}
		for(int j=0;j<width+2;j++)
		{
			//System.out.print("#");
			disp.setLog("#");
		}
		//System.out.print("\n");
		disp.setLog("\n");
		//System.out.print("\n");
		//disp.setLog("\n");
	}
}
