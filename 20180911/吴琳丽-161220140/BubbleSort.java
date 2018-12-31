public class BubbleSort {
    public static void main(String args[]) {
        int[] Array = new int[]{3, 4, 1, 8, 2, 1, 5};
        for (int p = 0; p < Array.length - 1; p++)
            for (int q = 0; q < Array.length - p - 1; q++) {
                if (Array[q] > Array[q + 1]) {
                    int temp = Array[q];
                    Array[q] = Array[q + 1];
                    Array[q + 1] = temp;
                }
            }
        for (int i = 0; i < Array.length; i++)
            System.out.println(Array[i]);
    }
}
