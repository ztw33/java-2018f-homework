package hw2;
//葫芦娃类，包含葫芦娃的属性和构造方法
class CalabashBrother{
	private int number;
	private String name;
	private String color;
	public CalabashBrother(int i)
	{
		number=i;
		switch(number)
		{
		case 1:name="大娃";color="红色";break;
		case 2:name="二娃";color="橙色";break;
		case 3:name="三娃";color="黄色";break;
		case 4:name="四娃";color="绿色";break;
		case 5:name="五娃";color="青色";break;
		case 6:name="六娃";color="蓝色";break;
		case 7:name="七娃";color="紫色";break;
		default:break;
		}
	}
	public int getNumber() {return number;}
	public String getName() {return name;}
	public String getColor() {return color;}
};
//葫芦娃队列类，包含七个葫芦娃的队列，以及打乱、排序的方法
class CalabashBrotherQueue
{
	//类数组存储七个葫芦娃，方便知晓当前位置
	private CalabashBrother[] sevenCBS=new CalabashBrother[7];
	CalabashBrotherQueue()
	{
		for(int i=1;i<=7;i++) 
		{
			sevenCBS[i-1]=new CalabashBrother(i);
		}
	}
	//打印葫芦娃序列
	public void show()
	{
		for(int i=0;i<7;i++)
		{
			System.out.printf("%s ",sevenCBS[i].getName());
		}
		System.out.printf("\n");
	}
	//随机打乱方法
	public void upset(int time)
	{	
		java.util.Random random=new java.util.Random();
		for(int j=0;j<time;j++)
		{
			for(int i=0;i<=6;i++)
			{
				int iRandom = random.nextInt(7);
				CalabashBrother temp=sevenCBS[iRandom];
				sevenCBS[iRandom]=sevenCBS[i];
				sevenCBS[i]=temp;
			}
		}
	}
	//冒泡法按照姓名排序
	public void sortByName()
	{
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<6-i;j++)
			{
				if(sevenCBS[j].getNumber()>sevenCBS[j+1].getNumber())
				{
					CalabashBrother temp=sevenCBS[j];
					System.out.printf("%s：%d->%d\n",sevenCBS[j+1].getName(),j+2,j+1);
					sevenCBS[j]=sevenCBS[j+1];
					System.out.printf("%s：%d->%d\n",temp.getName(),j+1,j+2);
					sevenCBS[j+1]=temp;
				}
			}
		}
	}
	//二分法按照颜色排序
	public void sortByColor()
	{
		for (int i=0;i<7;i++)
		{
			CalabashBrother temp=sevenCBS[i];
			int left=0;
			int right=i-1;
			int middle=0;
			while(left <= right)
			{
				middle = (left + right)/2;
				if(temp.getNumber()<sevenCBS[middle].getNumber())
				{
					right = middle-1;
				}
				else
				{
					left = middle + 1;
				}
			}
			for(int j = i-1;j>=left;j--)
			{
				System.out.printf("%s：%d->%d\n",sevenCBS[j].getName(),j+1,j+2);
				sevenCBS[j+1] = sevenCBS[j];
			}
			if(left!=i)
			{
				System.out.printf("%s：%d->%d\n",temp.getName(),i+1,left+1);
				sevenCBS[left]=temp;
			}
		}
	}
};
//主类，包含main方法
//一开始程序总是找不到主类，后来在run configuration里面设置Main Class为hw2.CalabashBrotherSolve即可
public class CalabashBrotherSolve {
	public static void main(String[] args)
	{
		CalabashBrotherQueue CBS = new CalabashBrotherQueue();
		System.out.println("初始化：");
		CBS.show();
		System.out.println("随机打乱序列：");
		CBS.upset(3);
		CBS.show();
		System.out.println("根据姓名冒泡排序：");
		CBS.sortByName();
		CBS.show();
		System.out.println("再次打乱：");
		CBS.upset(3);
		CBS.show();
		System.out.println("根据颜色二分排序：");
		CBS.sortByColor();
		CBS.show();
	}
}
