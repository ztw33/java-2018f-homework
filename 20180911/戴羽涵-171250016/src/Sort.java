public class Sort {
	/**
	 * 选择排序
	 * @param a  要排序的数组
	 */
	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int indexOfMin=i;
			for(int j=i+1;j<a.length;j++)  // 寻找从索引i+1开始的最小数的索引
				if(less(a[j],a[indexOfMin]))
					indexOfMin=j;
			exchange(a,i,indexOfMin);
		}
	}

	/**
	 * 将数组中的两个指定索引的元素交换
	 * @param a  要交换元素的数组
	 * @param x  索引
	 * @param y  索引
	 */
	private static void exchange(int[] a,int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	private static boolean less(int m, int n) {
		return m<n;
	}

	public static void print(int[] a) {
		for (int num:a) {
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		int[] a = {123, 34, 32, 2, 5, 43, 63, 4, 6457};
		sort(a);
		print(a);
	}
}
