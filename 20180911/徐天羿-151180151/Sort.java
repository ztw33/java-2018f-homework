package Sort;
import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int[] array = {10,11,7,56,27,65,97,3,10,48};
		int i,j;
		for(i = 0; i < array.length; i++) {
			for(j = i + 1; j < array.length; j++) {
				int temp;
				if(array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;}
				}
			}
		System.out.println(Arrays.toString(array));
		}
}
