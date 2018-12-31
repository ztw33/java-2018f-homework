package code;
import java.util.Random;
/*enum Color{
	Red,Orange,Yellow,Green,Cyan,Blue,Purple
}*/
//葫芦娃类
class CalabashBrothers{
	static String[] RankName= {"老大","老二","老三","老四","老五","老六","老七"};
	static String[] Color= {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
	private int rank;		//int类型的排行(1~7)
	private String color;	//颜色
	private String nickname;//绰号,如"老大"、"老二"等
	CalabashBrothers(int r){	//构造函数
		rank=r+1;				
		color=Color[r];			
		nickname=RankName[r];	
	}
	//显示葫芦娃的信息
	void ShowInfo() {			
		System.out.println(rank+" "+nickname+" "+color);
	}
	//以下三个函数为私有变量访问接口
	int get_rank() {
		return rank;
	}
	String get_color() {
		return color;
	}
	String get_nickname() {
		return nickname;
	}
	
	//判断一个葫芦娃是否比另一个葫芦娃排行更高
	boolean rank_higher_than(CalabashBrothers another) {
		boolean result=rank<another.rank?true:false;
		return result;
	}
}
public class SortBrothers {
	static int numofBrothers=7;	//葫芦娃的数量
	//产生[left,right]的无重复随机序列
	static int[] get_random_series(int left,int right) {
		Random r=new Random();
		int size=right-left+1;
		int[] series=new int[size];			//数组的声明方法
		boolean[] flags=new boolean[size];	//用一个布尔类型的数组标记数字是否已经存在
		for(int i=0;i<size;i++) {
			flags[i]=false;
		}
		int randint=0;
		//以下这个for循环为本函数的核心
		for(int i=0;i<size;i++) {
			do {
				randint=r.nextInt(size)+left;
				
			}while(flags[randint]);	//若该数字已存在则重新生成
			flags[randint]=true;
			series[i]=randint;
		}
		return series;
	}
	//按rank进行冒泡排序,传入形参为CalabashBrothers类型的数组
	//为了在主函数中直接饮用,该函数应该定义为static
	static void bubble_sort(CalabashBrothers[] cbs) {
		for(int i=cbs.length-1;i>=1;i--) {
			for(int j=0;j<i;j++) {
				if(cbs[j].get_rank()>cbs[j+1].get_rank()) {
					//排序过程中进行位置移动的报告
					System.out.print(cbs[j].get_nickname()+": "+j+"->"+(j+1)+"  ");
					System.out.print(cbs[j+1].get_nickname()+": "+(j+1)+"->"+j+"  ");
					CalabashBrothers tmp=cbs[j];
					cbs[j]=cbs[j+1];
					cbs[j+1]=tmp;
				}
			}
		}
	}
	
	//用二分法进行排序
	//相当于插入排序的改进,即用二分法查找最佳插入位置
	static void binary_sort(CalabashBrothers[] cbs) {
		for(int i=0;i<cbs.length-1;i++) {		//已排序的序列不断往后推移
			//这三个量表示的是已排序序列的开始、结尾和中间
			int start=0,end=i,mid=(start+end)/2;
			CalabashBrothers tmp=cbs[i+1];
			
			while(start<=end) {
				mid=(start+end)/2;
				if(cbs[mid].get_rank()>tmp.get_rank()) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			for(int j=i;j>end;j--) {
				System.out.print(cbs[j].get_nickname()+": "+j+"->"+(j+1)+" ");
				cbs[j+1]=cbs[j];
			}
			if((i+1)!=(end+1)){
				System.out.print(tmp.get_nickname()+": "+(i+1)+"->"+(end+1)+" ");				
			}
			cbs[end+1]=tmp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建葫芦娃兄弟的数组
		CalabashBrothers[] brothers=new CalabashBrothers [numofBrothers];
		int[] series=new int[numofBrothers];
		//生成随机序列
		series=get_random_series(0,numofBrothers-1);
		//调用构造函数对数组进行初始化
		for(int i=0;i<brothers.length;i++) {
			brothers[i]=new CalabashBrothers(series[i]);
		}
		System.out.println("初始排序:");
		//报数
		for(int j=0;j<brothers.length;j++) {
			//brothers[j].ShowInfo();
			System.out.print(brothers[j].get_nickname()+" ");
		}
		//排序
		bubble_sort(brothers);
		System.out.println("");
		System.out.println("冒泡排序后结果:");
		for(int j=0;j<brothers.length;j++) {
			//brothers[j].ShowInfo();
			System.out.print(brothers[j].get_nickname()+" ");
		}
		
		//再次生成随机序列
		series=get_random_series(0,numofBrothers-1);
		//int test[]= {6,4,3,5,2,1,0};
		for(int i=0;i<numofBrothers;i++) {
			brothers[i]=new CalabashBrothers(series[i]);
		}
		System.out.println("");
		System.out.println("再次随意站队:");
		for(int j=0;j<brothers.length;j++) {
			System.out.print(brothers[j].get_nickname()+" ");
		}
		System.out.println("");
		//二分法进行排序
		binary_sort(brothers);
		System.out.println("");
		System.out.println("排序后按颜色报数:");
		for(int j=0;j<brothers.length;j++) {
			System.out.print(brothers[j].get_color()+" ");
		}
	}

}
