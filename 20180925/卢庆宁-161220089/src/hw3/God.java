package hw3;

public class God {				//上帝类，创建各类对象并整体操作
	private static Board b;			//棋盘
	private static Formation f[];	//阵型
	private static Good good;		//好人阵营
	private static Bad bad;			//坏人阵营
	private static Display display;	//图形界面
	God()
	{
		initBoard(10,20);
		initFormation();
		initCamp();
		initDisplay();
	}
	public void initBoard(int height,int width)
	{
		b=new Board(height,width);
	}
	public void initFormation()
	{		
		f=new Formation[4];
		f[0]=new Snake();
		f[1]=new Goose();
		f[2]=new Yoke();
		f[3]=new Crane();	
	}	
	public void initCamp()
	{
		good=new Good(0,0);
		b.testAndSet(good.boss);
		good.soldiers.upset(3);
		good.soldiers.sort();
		good.soldiers.set(b,1,1,f[0]);
		bad=new Bad(0,19,8);
		b.testAndSet(bad.boss);
		bad.soldiers.set(b,1,18,f[0]);
	}
	public void initDisplay()
	{
		display=new Display(b,bad.soldiers.getNumber());
	}
	public void versusInfo(Display disp)			//输出对阵信息
	{
		disp.setLog(good.soldiers.getFormationName()+" 对阵 "+bad.soldiers.getFormationName()+"\n\n");
	}
	public void run() throws InterruptedException	//程序运行
	{
		b.showAll(display);
		display.change(b);
		versusInfo(display);
		
		int i=1;
		while(true)
		{
			Thread.sleep(100);						//循环检测按钮的点击情况
			if (display.getButtonCount()==i)
			{
				bad.soldiers.reset(b);				//妖怪变阵并输出
				bad.soldiers.set(b,1,18,f[i++]);
				good.soldiers.reset(b);
				good.soldiers.upset(3);				//葫芦娃也乱序一下
				good.soldiers.set(b,1,1,f[0]);
				b.showAll(display);
				display.change(b);
				versusInfo(display);
				if(i==4)							//回到初始情况
				{
					i=0;
					display.setButtonCount(-1);
				}
			}
		}
	}
}