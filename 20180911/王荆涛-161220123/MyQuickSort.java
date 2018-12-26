package Sort;
import java.util.*;

/**The first assignment.
 * Create an array list and sort it's elements by MyQuickSort.
 * @author Jingtao Wang
 * @author 161220123
 * @version 1.0
 */


public class MyQuickSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numArray = new int[10];
        for(int i = 0; i < 10; i++)
            numArray[i] = rand.nextInt(100) + 1;

        sort(numArray, 0, 9);

        for(int i = 0; i < 10; i ++)
            System.out.print(numArray[i] + " ");
    }

    static int partition(int[] a, int firstIndex, int lastIndex){
        int pivot = a[lastIndex];
        int i = firstIndex - 1;
        int j = firstIndex;
        int tempNum = 0;
        for(;j < lastIndex; j++){
            if(a[j] < pivot){
                i++;
                tempNum = a[i];
                a[i] = a[j];
                a[j] = tempNum;

            }
        }
        tempNum = a[i + 1];
        a[i + 1] = a[lastIndex];
        a[lastIndex] = tempNum;
        return i + 1;
    }

    static void sort(int[] a, int firstIndex, int lastIndex){
        if(firstIndex < lastIndex){
            int q = partition(a, firstIndex, lastIndex);
            sort(a, firstIndex, q - 1);
            sort(a, q + 1, lastIndex);
        }
    }
}