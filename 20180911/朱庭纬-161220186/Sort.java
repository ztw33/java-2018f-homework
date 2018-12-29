package project1;

import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 输入整数并以空格隔开 */
		System.out.println("Please input the integers, split with space:");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] strArray = input.split(" ");
		int[] numbers = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			numbers[i] = Integer.parseInt(strArray[i]);
		}
		
		QuickSort(numbers, 0, numbers.length-1);
		for (int k:numbers) {
			System.out.print(k + " ");
		}
	}
	
	/* 找到基准元素所在位置并将数组划分为两部分 */
	public static int Partition(int[] numbers, int low, int high) {
		int pivot = numbers[high];
		int i = low-1;
		for (int j = low; j < high; j++) {
			if (numbers[j] < pivot) {
				i++;
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
			}
		}
		int temp = numbers[i+1];
		numbers[i+1] = numbers[high];
		numbers[high] = temp;
	    return i+1;
	}
	
	/* 快速排序 */
	public static void QuickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int pivot = Partition(numbers, low, high);
			QuickSort(numbers, low, pivot - 1);
			QuickSort(numbers, pivot+1, high);
		}		
	}
	
}
