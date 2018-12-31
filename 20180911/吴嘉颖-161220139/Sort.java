// homework 1

import java.util.Scanner;
import java.util.Arrays;

public class Sort {
    private static void BubbleSort(int array[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        // input the number of elements
        System.out.println("Please enter the number of elems; ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int array[] = new int[size];

        // input numbers
        System.out.println("Please enter numbers; ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        // sort array
        BubbleSort(array, size);

        // output array
        System.out.println(Arrays.toString(array));
    }
}
