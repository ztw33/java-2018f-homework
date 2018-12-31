public class Sort {
    public static void main(String[] args) {
        int[] num = new int[]{83, 45, 13, 22, 11, 67, 91, 50, 43, 66};
        bubbleSort(num);
        Output(num);
    }

    static void bubbleSort(int[] num) {
        int tmp;
        for (int i = 0; i < num.length - 1; ++i)
            for (int j = 0; j < num.length - 1 - i; ++j)
                if (num[j] > num[j + 1]) {
                    tmp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = tmp;
                }
    }

    static void Output(int[] num) {
        for (int i : num)
            System.out.print(i + " ");
    }
}
