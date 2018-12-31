import java.util.Scanner;

public class my_sort {

    public void my_sort(int[] a) {

        for (int i = 0; i < a.length; i++)
        {
            for (int j = i+1; j < a.length; j++)
            {
                if(a[j] < a[i])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for(int i : a)
        {
            System.out.print(i + ", ");
        }

    }

    public static void main(String[] args) {

        int[] a = {8,4,6,2,3,1,5,7};
        my_sort sort1 = new my_sort();
        sort1.my_sort(a);
    }

}
