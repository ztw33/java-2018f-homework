import java.util.*;

public class sort {
    public static int find_pivot(int[] num_array, int left, int right) {
        int pivot = left;
        int i = left + 1;
        while(i <= right) {
            if(num_array[i] < num_array[pivot]) {
                pivot++;
                if(pivot != i) {
                    int temp = num_array[pivot];
                    num_array[pivot] = num_array[i];
                    num_array[i] = temp;
                }
            }
            i++;
        }
        int temp = num_array[pivot];
        num_array[pivot] = num_array[left];
        num_array[left] = temp;
        return pivot;
    }
    public static void quick_sort(int[] num_array, int left, int right) {

        if(left < right) {
            int pivot = find_pivot(num_array, left, right);
            quick_sort(num_array, left, pivot - 1);
            quick_sort(num_array, pivot + 1, right);
        }

    }

    public static void main(String[] args) {
        System.out.println("Please input the length of the array");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int[] array = new int[number];
        System.out.println("Please input " + number + " integer");
        for(int i = 0; i < number; i++) {
            array[i] = in.nextInt();
        }
        quick_sort(array,0,number - 1);
        for (int i = 0; i < number; i++) {
            System.out.print(array[i]);
            System.out.print(' ');
        }
    }

}
