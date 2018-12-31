import java.util.Scanner;
public class ArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("数组长度：");
        int len = sc.nextInt();
        int[] A = new int[len];
        System.out.print("输入数组：");
        for (int i = 0; i < len; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < len; i++) {
            int minP = i;
            for (int j = i + 1; j < len; j++) {
                if (A[j] < A[minP])
                    minP = j;
            }
            int tmp = A[i];
            A[i] = A[minP];
            A[minP] = tmp;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }
}