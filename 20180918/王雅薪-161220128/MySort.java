package Assignment2;

import java.util.Random;
public class MySort {
	MySort(){}
	/*冒泡排序*/
	public void BubbleS(Cucurbit []C,int n){
		for(int i = 0; i < n-1; i++){
			for(int j = 0; j < n-1-i; j++){
				int a = C[j].getNum();
				int b = C[j+1].getNum();
				if( a > b){
					Cucurbit t = C[j];
					C[j] = C[j+1];
					C[j+1] = t;
					System.out.println(a+"娃:"+j+"->"+(j+1));
					System.out.println(b+"娃:"+(j+1)+"->"+j);
				}
			}
		}
		System.out.print("冒泡排序报数：");
		for(int i = 0; i < n; i++){
			C[i].numberOff();
			//C[i].colorOff();
		}
		System.out.println();
	}
	
	/*二分法排序*/
	public void DichotomyS(Cucurbit []C,int n){
		for(int i = 0; i < n; i++){
			int left = 0;
			int right = i-1;
			int mid = 0;
			Cucurbit t = C[i];
			while(left <= right){
				mid = (left+right)/2;
				if(C[mid].getColor().ordinal() > t.getColor().ordinal()){
					right = mid-1;
				}
				else{
					left = mid+1;
				}
			}
			for(int j = i-1; j > right; j--){
				C[j+1] = C[j];
				System.out.println(C[j].getNum()+"娃:"+j+"->"+(j+1));
			}
			if(i != (right+1)){
				C[right+1] = t;
				System.out.println(t.getNum()+"娃:"+i+"->"+(right+1));
			}
		}
		System.out.print("二分法报数：");
		for(int i = 0; i < n; i++){
			//C[i].numberOff();
			C[i].colorOff();
		}
		System.out.println();
	}
	
	/*随机站队*/
	public void RandomS(Cucurbit []C,int n){
		Random R = new Random();
		for(int i = n-1; i >= 0; i--){
	        int index= (R.nextInt(n)+1)%n;
	        if(i != index){
	        	Cucurbit t = C[i];
				C[i] = C[index];
				C[index] = t;
	        }
		}
		System.out.println("随机站队完成");
	    for(int i = 0; i < n; i++){
			C[i].numberOff();
			C[i].colorOff();
		}
		System.out.println();
	}
}