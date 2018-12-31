package BubbleSort;

import java.util.Scanner;

public class BubbleSort {
	public static void Bsort(int[] arr, int num) {
		for(int i = 0; i < num - 1; i++) {
			for(int j = num - 1; j >= i + 1; j--) {
				if(arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int num;
		int []array;
		System.out.println("Please input the scale of the array:");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		array = new int[num];
		System.out.println("Please input the unsorted array:");
		for(int i = 0; i < num; i++)
			array[i] = sc.nextInt();
		Bsort(array, num);
		System.out.println("Here comes the sorted array:");
		for(int i = 0; i < num; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
		sc.close();
	}
}
