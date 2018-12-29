package homework;
import java.util.*;

public class TechnologyOfSort {
	public static int[] binarySearchSort(int[] cucurbit) {
		ArrayList<Integer> cucurbitList = new ArrayList<Integer>();
		cucurbitList.add(0,cucurbit[0]);
		for(int i = 1; i < cucurbit.length; i++) {		 
				int high = i-1;
				int low = 0;
				
				while(low <= high) {
					int middle = (low + high) / 2;
					if(cucurbit[middle] < cucurbit[i])
						low = middle + 1;
					else 
						high = middle - 1;
				}
				cucurbitList.add(high+1, cucurbit[i]);
		}
		int[] cucurbits = new int[7];
		for(int i = 0; i < 7; i++) {
			cucurbits[i] = cucurbitList.get(i);
		}
		return cucurbits;
	}
	public static int[] bubleSort(int[] cucurbit) {
		int temp;
		for(int i = 0; i < (cucurbit.length-1); i++) {
			for(int j = 0; j < (cucurbit.length-1-i); j++){
				if(cucurbit[j] > cucurbit[j+1]) {
					temp = cucurbit[j];
					cucurbit[j] = cucurbit[j+1];
					cucurbit[j+1] = temp;
				}
			}
		}
		return cucurbit;
	}
}
