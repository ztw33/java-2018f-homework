public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] { 77, 6, 2, 7, 22, 10, 36, 88, 9, 11 };
		/* use bubble sort */
		int tmp = 0;
		for (int i = 8; i > 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (num[j] > num[j + 1]) {
					tmp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = tmp;
				}
			}
		}
		System.out.println("From the smallest to biggest:");
		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}
	}

}

