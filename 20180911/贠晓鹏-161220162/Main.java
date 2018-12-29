public class Main{
    public static void main(String[] args) {
        // write your code here
        int []A={1,9,7,2,5,4,6,8,3,10};
        for (int x = 0; x < 9; x++) {
            for (int y = x + 1; y < 10; y++) {
                if (A[x] > A[y]) {
                    int temp = A[x];
                    A[x] = A[y];
                    A[y] = temp;
                }
            }
        }
        for(int j=0;j<10;j++)
        {
            System.out.print(A[j]+" ");
        }
    }
}
