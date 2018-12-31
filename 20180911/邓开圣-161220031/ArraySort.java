package hw;
import java.util.*;	//引入java.util以支持输入流

public class ArraySort {
	String[] numString;	//字符串数组,用于支持不确定长度的数组输入
	int num[];			//int型的数组
	ArraySort(){numString=null;num=null;};
	int partition(int left,int right) {	//分隔
		int p1=left,p2=right;
		int boundary=num[p1];
		while(p1<p2) {
			while((p1<p2)&&num[p2]>=boundary)
				p2--;
			num[p1]=num[p2];
			while((p1<p2)&&(num[p1]<=boundary))
				p1++;
			num[p2]=num[p1];
		}
		num[p1]=boundary;
		return p1;
	}
	void qsort(int left,int right) {	//快速排序
		if(left<right) {
			int pivot=partition(left,right);
			qsort(left,pivot-1);
			qsort(pivot+1,right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);	//初始化Scanner
		ArraySort AS=new ArraySort();		//实例化一个ArraySort对象
		System.out.println("Please input an integer array(split by ' '):");
		AS.numString=in.nextLine().split(" ");	//连续输入字符串并以空格作为分隔符
		in.close();		//关闭输入流
		AS.num=new int[AS.numString.length];	//根据输入的字符串为num分配内存空间
		for(int i=0;i<AS.numString.length;i++) {
			AS.num[i]=Integer.valueOf(AS.numString[i]);	//利用Integer类的valueOf方法对字符串进行解析
		}
		AS.qsort(0, AS.num.length-1);	//对数组进行快速排序
		System.out.println("Sorting result:");
		for(int a:AS.num) {	//用foreach循环输出数组中的元素
			System.out.print(a+" ");
		}
	}

}

