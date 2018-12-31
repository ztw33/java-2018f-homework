import java.util.Random;

public class Sort {
	public static void selectionSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int minDataIndex = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[minDataIndex]) {
					minDataIndex = j;
				}
			}
			if (minDataIndex != i) {
				// swap
				int temp = data[i];
				data[i] = data[minDataIndex];
				data[minDataIndex] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// selectionSort test
		final int TEST_TIMES = 10;
		final int ARRAY_LENGTH = 10;
		Random random = new Random(47);
		for (int times = 0; times < TEST_TIMES; times++) {
			// generate random array
			int[] intArray = new int[ARRAY_LENGTH];
			System.out.print("Before: ");
			for (int i = 0; i < intArray.length; i++) {
				intArray[i] = random.nextInt(100);
				System.out.print(intArray[i] + " ");
			}
			System.out.println();

			// do selectionSort
			Sort.selectionSort(intArray);

			// print current array
			System.out.print("After: ");
			for (int i = 0; i < intArray.length; i++) {
				System.out.print(intArray[i] + " ");
			}
			System.out.println();

			// check whether sorted
			boolean isSorted = true;
			for (int i = 0; i < intArray.length - 1; i++) {
				if (intArray[i] > intArray[i + 1]) {
					isSorted = false;
				}
			}
			System.out.println("Sorted: " + isSorted);
			System.out.println();

		}
	}
}
