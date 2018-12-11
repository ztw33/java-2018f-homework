package sort;

import java.util.Random;

enum Color{
	红色,橙色,黄色,绿色,青色,蓝色,紫色;
}
enum Name{
	老大,老二,老三,老四,老五,老六,老七;
}
public enum CalabashBrothers {
	One(Name.老大,Color.红色),
	Two(Name.老二,Color.橙色),
	Three(Name.老三,Color.黄色),
	Four(Name.老四,Color.绿色),
	Five(Name.老五,Color.青色),
	Six(Name.老六,Color.蓝色),
	Seven(Name.老七,Color.紫色);
	
	private Name name;
	private Color color;
	
	private CalabashBrothers(Name n,Color c) {
		this.name = n;
		this.color = c;
	}
	
	public Name getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	public void swapClaim(Name people,int old_location,int new_location) {
		System.out.println(people+":"+old_location+"->"+new_location);
	}
}

class CalabashQueue {
	Random random = new Random();
	public void RandomSort(CalabashBrothers[] Calabash) {
		System.out.println("初始化队列开始");
		for(int i=0;i<Calabash.length;i++) {
			int p=random.nextInt(i+1);
			CalabashBrothers temp=Calabash[i];
			Calabash[i]=Calabash[p];
			Calabash[p]=temp;
		}
		System.out.println("初始化队列结束");
	}
	
	public void BubbleSort(CalabashBrothers[] Calabash) {
		System.out.println("\n冒泡排序开始");
		for(int i=0;i<Calabash.length;i++) {
			for(int j=i+1;j<Calabash.length;j++) {
				if(Calabash[i].ordinal()>Calabash[j].ordinal()) {
					Calabash[i].swapClaim(Calabash[i].getName(), i, j);
					CalabashBrothers Temp=Calabash[i];
					Calabash[i]=Calabash[j];
					Calabash[j]=Temp;
				}
			}
		}
		System.out.println("冒泡排序结束");
	}
	
	public void BinarySort(CalabashBrothers[] Calabash) {
		System.out.println("\n二分排序开始");
		for(int i=1;i<Calabash.length;i++) {
			CalabashBrothers temp=Calabash[i];
			int temp_old_location=i;
			int low=0,high=i-1;
			int mid=-1;
			while(low<high) {
				mid=low+(high-low)/2;
				if(temp.getColor().ordinal()<Calabash[mid].getColor().ordinal()) 
					high=mid-1;
				else
					low=mid+1;
			}
			for(int j=i-1;j>=low;j--) {
				Calabash[j+1]=Calabash[j];
			}
			Calabash[low]=temp;
			Calabash[low].swapClaim(Calabash[low].getName(),temp_old_location,low);
		}
		System.out.println("二分排序结束");
	}
	
	public void queueClaimName(CalabashBrothers[] Calabash) {
		System.out.println("\n报数开始");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getName());
		System.out.println("报数结束\n");
	}
	
	public void queueClaimColor(CalabashBrothers[] Calabash) {
		System.out.println("\n报颜色开始");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getColor());
		System.out.println("报颜色结束");
	}

	
}
