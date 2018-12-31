package njucs.java2018;

public class Sort {
    public static void main(String[] args) {
        int numbers[] = new int[] { 1, 3, 999, 64, 82, 10, 100, 66, 93, 121 };
        SelectionSort(numbers, numbers.length);
        for(int i = 0; i < numbers.length; i ++)
            System.out.print(numbers[i] + " ");
    }

    public static void SelectionSort(int a[] , int num) {
        for(int i = 0; i < num - 1; i ++) {
            int index = i;
            for(int j = i + 1; j < num; j ++)
                if(a[j] < a[index])
                    index = j;
            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
        }
    }
}
