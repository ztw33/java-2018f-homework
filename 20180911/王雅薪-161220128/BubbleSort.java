package assignment1;

public class BubbleSort {
	public static void main(String[] args) {
		int n = 8;
		int a[] = {2,3,5,1,4,9,7,8};
		
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				if(a[i] > a[j]){
					int t = a[j];
					a[j] = a[i];
					a[i] = t;
				}
			}
		}
		
		for(int i = 0; i < n; i++){
			System.out.print(a[i]+" ");
		}
	}
}
