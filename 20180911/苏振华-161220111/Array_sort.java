package sort;

public class Array_sort { 
	private static int [] Array_int = {4, 6, 8, 2, 3, 1, 9, 7, 5};
	private static void My_sort(int Array[]) { //—°‘Ò≈≈–Ú≤¢¥Ú”°
        for(int i = 0; i < Array.length; i++) {
        	int min = i;
        	for(int j = i + 1; j < Array.length; j++)
        		if(Array[j] < Array[min])
        			min = j;
        	if(min != i) {
        		int temp = Array[min];
        		Array[min] = Array[i];
        		Array[i] = temp;
        	}
        }
        for(int i = 0; i < Array.length; i++) 
        	System.out.print(Array[i] + " ");
        System.out.print("\n");
	}
	public static void main(String[] args) {
		My_sort(Array_int);
    }
}
