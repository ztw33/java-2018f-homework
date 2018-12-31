public class ArraySort {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 5, 6, 0};
        int i = 0, j = 0;
        int min = a[0];
        for (i = 0; i < a.length; i++) {
            min=a[i];
            for (j = i; j < a.length; j++) {
                if (a[j] < min) {
                    int temp=a[j];
                    a[j]=min;
                    a[i]=temp;
                    min=temp;
                }
            }
        }
        for(i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}
