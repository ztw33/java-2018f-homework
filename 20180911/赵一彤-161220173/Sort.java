import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
        int size = 5;
        int[] array = new int[size];
        System.out.println("Please input " + size + " integers");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        // BubbleSort
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }

        // print sorted numbers
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

    }

}
