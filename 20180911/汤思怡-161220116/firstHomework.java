package firstHomework;

public class quickSort {

	static int[] intArray = new int[] { 8, 32, 98, 10, 39, 1, 7, 23, 19 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		quickSort.qSort(intArray, 0, intArray.length - 1);
		quickSort.printArray(intArray);

	}

	public static void qSort(int a[], int left, int right) {
		if (left >= right) {
			return;
		}
		int first = left, last = right, pivot = a[first];
		while (first < last) {
			while (first < last && a[last] >= pivot) {
				last--;
			}
			a[first] = a[last];
			while (first < last && a[first] <= pivot) {
				first++;
			}
			a[last] = a[first];
		}
		a[first] = pivot;
		qSort(a, left, first - 1);
		qSort(a, first + 1, right);
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
