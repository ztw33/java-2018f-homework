package java_homework1;
import java.util.Scanner;
/**
 * Simple code for sorting using different algorithms.
 * 1. bubble sort
 * 2. quick_sort
 * 3. merge sort
 * 9/13 2018
 * @author why
 *
 */

public class Sort {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Input to create the specific random nums:");
		int n = in.nextInt();
		in.close();
		int []a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = (int)(Math.random()*100);
		}
		for (int k:a) {
			System.out.print(k+"\t");
		}
		
		bubble(a.clone());
		int[] qs = quickSort(a.clone(), 0, a.length-1);
		System.out.println("\nAfter quick sort:");
		for (int k:qs) {
			System.out.print(k+"\t");
		}
		
		int[] mer = merge(a.clone());
		System.out.println("\nAfter merge sort:");
		for (int k:mer) {
			System.out.print(k+"\t");
		}
	}
	
	public static void bubble(int[] x) {
		int len = x.length;
		for (int i=0; i<len; i++) {
			for (int j=0; j<len-i-1;j++) {
				if (x[j]>x[j+1]) {
					swap(x,j,j+1);
				}
			}
		}
		System.out.println("\nAfter Bubble sort:");
		for (int k:x) {
			System.out.print(k+"\t");
		}
	}
	
	public static int[] quickSort(int[] x, int m, int n) {
		if (m == n || m>n) {
			return x;
		}
		int mid = partion(x, m, n);
		quickSort(x, m, mid-1);
		quickSort(x, mid+1, n);
		return x;
	}
	
	public static int[] merge(int[] x) {
		int len = x.length;
		if (len==1) {
			return x;
		}
		int [] x1 = copy(x, 0, len/2);
		int [] x2 = copy(x, len/2, len);
		
		int[] part1 = merge(x1);
		int[] part2 = merge(x2);
		
		return together(part1, part2);
	}
	
	public static int[] choose(int[] x) {
		return x;
	}
	
	public static void swap(int[] x, int i, int j) {
		int temp;
		temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
	
	public static int partion(int[] x, int m, int n) {
		int pivot = m;
		int head = m+1;
		int tail = n;
		for (int i=head; i<=tail; i++) {
			if (x[i]>x[pivot]) {
				swap(x, i, tail);
				tail--;
				i--;
			}
		}
		swap(x, pivot, tail);
		return tail;
	}

	public static int[] copy(int[] x, int m, int n) {
		int[] temp = new int[n-m];
		for (int i=0; i<temp.length; i++) {
			temp[i] = x[m+i];
		}
		return temp;
	}
	
	public static int[] together(int[] x1, int[] x2) {
		int len = x1.length + x2.length;
		int[] ans = new int[len];
		int i = 0; int j= 0;
		int k = 0;
		while(i<x1.length && j<x2.length) {
			if (x1[i]<x2[j]) {
				ans[k++] = x1[i++];
			}
			else if (x1[i]>=x2[j]) {
				ans[k++] = x2[j++];
			}
		}
		if (i<x1.length) {
			while (i<x1.length) {
				ans[k++] = x1[i++];
			}
		}
		else if (j<x2.length) {
			while (j<x2.length) {
				ans[k++] = x2[j++];
			}		
		}
		return ans;
	}
}
