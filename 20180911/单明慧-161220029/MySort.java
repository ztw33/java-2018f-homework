package sort;


class QuickSort{
	int[] arrayToSort = {5,3,7,1,2,9,10,4,6,8};
	void quickSortEntry(){
		quickSort(arrayToSort, 0, 9);
		for(int i = 0; i < 10; i++){
			System.out.println(arrayToSort[i]);
		}
	}
	void quickSort(int[] arrayToSort, int m, int n) {
		if (m >= n)
			return;
		else{
			int pivot = arrayToSort[m];
			int left = m, right = n;
			while (left < right){
				while (left < right && arrayToSort[right] > pivot){
					right--;
				}
				arrayToSort[left] = arrayToSort[right];
				while (left < right && arrayToSort[left] < pivot){
					left++;
				}
				arrayToSort[right] = arrayToSort[left];
			}
			arrayToSort[left] = pivot;
			quickSort(arrayToSort, m, left-1);
			quickSort(arrayToSort, left+1, n);
		}
	}
}

public class MySort{
	public static void main(String[] args){
		QuickSort test = new QuickSort(); 
		test.quickSortEntry();
		return;
	}
}
