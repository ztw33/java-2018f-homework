package work2_huluwa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sortchairs {
	//主函数
	public static void main(String [] args){
		Huluwa[] Hululist = new Huluwa[7];	
		//姑且把这个数组看成是一排椅子
		
		shuffle(Hululist);
		//随机生成一个葫芦娃数列，顺序是打乱的。
		
		bubblesort(Hululist);//冒泡排序
		
		printname(Hululist);//报名字
		
		shuffle(Hululist);//再次随机生成
		
		quicksort(Hululist,0,Hululist.length-1);//快速排序
		
		printcolor(Hululist);//报颜色
	} 
	
	public static void printname(Huluwa[] Hululist){
		for(int i = 0;i < 7;i++){ 
			Hululist[i].getname();
		}
		System.out.print("\n");
	}
	public static void printcolor(Huluwa[] Hululist){
		for(int i = 0;i < 7;i++){ 
			Hululist[i].getcolor();
		}
		System.out.print("\n");
	}

	public static void shuffle(Huluwa[] Hululist){    
		int[] x = {0,1,2,3,4,5,6};    
		List<Integer> list = new ArrayList<Integer> ();    
		for(int i = 0;i < x.length;i++){ 
			list.add(x[i]);    
		} 
	//	 System.out.println();
		 Collections.shuffle(list);   
		 for(int i = 0;i < 7;i++){ 
			 int p = list.get(i);
			 Hululist[i] = new Huluwa(p,i);
		} 
	}
	public static void bubblesort(Huluwa[] Hululist){
		for( int i = 0 ; i < 6;i++)
			for(int j = i+1; j <7;j++){
				if(Hululist[i].gettrue()>Hululist[j].gettrue()){
 					Hululist[i].changeplace(j);
					Hululist[j].changeplace(i);
					System.out.print("\n");
					//报告
					
					Huluwa tmp = Hululist[i];
					Hululist[i] = Hululist[j];
					Hululist[j] = tmp;
					//实质上的交换位置
				}
			}				
	}
    public static int divide(Huluwa[] H, int start, int end){
		//以最右边为基准值
		int base = H[end].gettrue();
		while(start < end){
			while(start < end && H[start].gettrue() <= base)
				//从左边开始遍历
				start++;
			
			if(start < end){
				H[start].changeplace(end);
				H[end].changeplace(start);
				System.out.print("\n");
				//报告
				Huluwa tmp = H[start];
				H[start] = H[end];
				H[end] = tmp;
				//实质上的交换位置

				end--;
			}	
			while(start < end && H[end].gettrue() >= base)
				//从右边开始遍历
				end--;
			if(start < end){
				H[start].changeplace(end);
				H[end].changeplace(start);
				System.out.print("\n");
				//报告
				Huluwa tmp = H[start];
				H[start] = H[end];
				H[end] = tmp;
				
				start++;
			}				
		}
		//基准值所在的位置
		return end;
	}
	public static void quicksort(Huluwa [] Hululist, int start, int end){
		if(start > end){
			//一个元素
			return;
		} 
		else{
			//递归
			int partition = divide(Hululist, start, end);
			quicksort(Hululist, start, partition-1);
			quicksort(Hululist, partition+1, end);
		}
			
	}
	
}
