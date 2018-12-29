package calabash;

import java.util.Random;

public class MySort {
	MySort(){}
	/*√∞≈›≈≈–Ú*/
	public void BubbleS(Calabash []C,int n){
		System.out.println("Bubble sort begins:");
		for(int i = 0; i < n-1; i++){
			for(int j = 0; j < n-1-i; j++){
				int a = C[j].getNum();
				int b = C[j+1].getNum();
				if( a > b){
					Calabash t = C[j];
					C[j] = C[j+1];
					C[j+1] = t;
					//System.out.println(a+"Õﬁ:"+j+"->"+(j+1));
					//System.out.println(b+"Õﬁ:"+(j+1)+"->"+j);
				}
			}
		}
		System.out.print("Bubble sort completes£∫");
		for(int i = 0; i < n; i++){
			C[i].numberOff();
			//C[i].colorOff()
		}
		System.out.println('\n');
	}
	
	/*∂˛∑÷∑®≈≈–Ú*/
	public void DichotomyS(Calabash []C,int n){
		System.out.println("Dichotomy sort begins:");
		for(int i = 0; i < n; i++){
			int left = 0;
			int right = i-1;
			int mid = 0;
			Calabash t = C[i];
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
				System.out.println(C[j].getNum()+"Õﬁ:"+j+"->"+(j+1));
			}
			if(i != (right+1)){
				C[right+1] = t;
				System.out.println(t.getNum()+"Õﬁ:"+i+"->"+(right+1));
			}
		}
		System.out.print("Dichotomy sort completes£∫");
		for(int i = 0; i < n; i++){
			//C[i].numberOff();
			C[i].colorOff();
		}
		System.out.println('\n');
	}
	
	/*ÀÊª˙’æ∂”*/
	public void RandomS(Calabash []C,int n){
		Random R = new Random();
		for(int i = n-1; i >= 0; i--){
	        int index= (R.nextInt(n)+1)%n;
	        if(i != index){
	        	Calabash t = C[i];
				C[i] = C[index];
				C[index] = t;
	        }
		}
		System.out.println("random station:");
	    for(int i = 0; i < n; i++){
			C[i].numberOff();
			C[i].colorOff();
		}
		System.out.println('\n');
	}
}
