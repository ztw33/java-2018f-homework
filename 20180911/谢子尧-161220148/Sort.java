//Homework 2018/09/11

class Sort {
	public static void main(String[] args) {
		int num[] = new int[] {1, 6, 2, 0, 4, 8, 11, 3, 5};
		
		for (int i = 1; i <= num.length - 1; ++i) {
			for (int j = 1; j <= num.length - i; ++j) {
				if(num[j - 1] >= num[j]) {
					int temp = num[j];
					num[j] = num[j - 1];
					num[j - 1] = temp;
				}
			}
		}

		for (int i = 0; i < num.length - 1; ++i) {
			System.out.print(num[i] + ", ");
		}
		System.out.println(num[num.length - 1]);
	}
}