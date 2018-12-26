package calabashBrothers;
import java.util.Random;
import calabashBrothers.CalabashBrothers;

public class CalabashBrothersSort {
	public void swapAndReport(CalabashBrothers[] bros, int i, int j) {
		CalabashBrothers temp;
		temp = bros[i];
		bros[i] = bros[j];
		bros[j] = temp;
		bros[i].report(i, j);
		bros[j].report(j, i);
	}
	
	
	public void randomSort(CalabashBrothers[] bros) {
		System.out.println("RandomSort:");
		
		Random random = new Random();
		int i;
		for(i = 0; i < bros.length; i++) {
			int j = random.nextInt(7);
			CalabashBrothers temp;
			temp = bros[i];
			bros[i] = bros[j];
			bros[j] = temp;
		}
	}
	
	public void bubbleSort(CalabashBrothers[] bros) {
		System.out.println("BubbleSort:");
		
		for(int i = 0; i < bros.length; i++) {
			for(int j = i + 1; j < bros.length; j++) {
				if(bros[i].getOrder() > bros[j].getOrder()) {
					swapAndReport(bros, i, j);
				}
			}
		}
	}
	
	public void binarySort(CalabashBrothers[] bros) {
		System.out.println("BinarySort:");
		
		for(int i = 0; i < bros.length; i++) {
			CalabashBrothers temp = bros[i];
			int left = 0;
			int right = i-1;
			int middle = 0;
			while(left <= right) {
				middle = (left + right) / 2;
				if(temp.getOrder() < bros[middle].getOrder()) {
					right = middle - 1;
				}
				else {
					left = middle + 1;
				}
			}			
			for(int j = i - 1; j >= left; j--) {
				bros[j+1] = bros[j];
				bros[j+1].report(j+1, j);
			}
			if(left != i) {
				bros[left] = temp;
				bros[left].report(left, i);
			}
		}
	}
	
	public void reportNames(CalabashBrothers[] bros) {
		for(int k = 0; k < bros.length; k++) {
			bros[k].reportName();
		}
		System.out.print("\n");
	}
	
	public void reportColors(CalabashBrothers[] bros) {
		for(int k = 0; k < bros.length; k++) {
			bros[k].reportColor();
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		CalabashBrothersSort sort = new CalabashBrothersSort();
		CalabashBrothers[] bros = CalabashBrothers.values();
		sort.randomSort(bros);
		sort.reportNames(bros);
		sort.bubbleSort(bros);
		sort.reportNames(bros);
		sort.randomSort(bros);
		sort.reportColors(bros);
		sort.binarySort(bros);	
		sort.reportColors(bros);
	}
}
