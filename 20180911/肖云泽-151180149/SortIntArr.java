import java.util.Random;

public class SortIntArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int[] array = new int[10];
		System.out.println("Before sort:");
		//initialize and print
		for (int i=0; i<array.length; i++) {
			array[i] = rand.nextInt(1000);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		//sort and print
		System.out.println("After sort:");
		for (int i=0; i<array.length; i++) {
			for (int j=i+1; j<array.length; j++) {
				if (array[i] >= array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
