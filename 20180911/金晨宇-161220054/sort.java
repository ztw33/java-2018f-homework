package sort;

public class sort {
	public static void sort(int[] num) {
		int len = num.length;
		for(int i = 0; i < len - 1; i++) {
			int min = i;
			for(int j = i + 1; j < len; j++)
			{
				if(num[j] < num[min])
				{
					min = j;
				}
			}
			int tmp = num[min];
			num[min] = num[i];
			num[i] = tmp;
		}
	}
	public static void main(String[] args) {
		int[] num = {10, 5 , 6, 7, 2, 9};
		sort(num);
		for(int i = 0; i < num.length; i++)
			System.out.println(num[i]);
	}
}
