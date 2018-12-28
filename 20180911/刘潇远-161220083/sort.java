import java.io.*;

class sort {
	private int array[]= {5,1,2,6,8,4,3,7,9,0};
	public sort() {
		
	}
	public void BubbleSort() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 9 - i; j++) {
				if(array[j]>array[j+1]) {
					int swaper = array[j];
					array[j] = array[j+1];
					array[j+1]=swaper;
				}
			}
		}
	}
	public void ShowResult() {
		for(int i = 0; i < 10; i++)
			System.out.print(array[i]+"\n");
	}
	public static void main(String args[]) {
		sort s = new sort();
		s.BubbleSort();
		s.ShowResult();
	}
}
