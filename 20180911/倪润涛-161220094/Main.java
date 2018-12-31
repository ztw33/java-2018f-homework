import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void swap(int []array, int x, int y) {
        int temp = array[x];
        array[x]  = array[y];
        array[y]  = temp;
    }

    public static void BubbleSort(int []array)
    {
        for(int i=0;i<array.length;i++)
        {
            for(int j=array.length-1;j>=1;j--)
            {
                if(array[j]<array[j-1])
                    swap(array, j,j - 1);
            }
        }
    }

    public static void SelectionSort(int []array)
    {
        for (int i = 0; i < array.length; i++)         // i为已排序序列的末尾
        {
            int min = i;
            for (int j = i + 1; j < array.length; j++)     // 未排序序列
            {
                if (array[j] < array[min])              // 找出未排序序列中的最小值
                {
                    min = j;
                }
            }
            if (min != i)
            {
                swap(array, min, i);
            }
        }
    }

    public static int Partition(int []array, int low, int high)
    {
        int top = low;
        int b = array[low];
        for (int i = low + 1; i <= high; i++)
        {
            if (array[i] < b)
            {
                top++;
                if (top != i)
                {
                    int temp = array[i];
                    array[i] = array[top];
                    array[top] = temp;
                }
            }
        }
        array[low] = array[top];
        array[top] = b;
        return top;
    }

    public static void QuickSort(int []array, int left, int right)
    {
        if (left < right)
        {
            int top = Partition(array,left, right);
            QuickSort(array, left, top - 1);
            QuickSort(array, top + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] BubbleSortArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
        BubbleSort(BubbleSortArray);
        System.out.print("冒泡排序算法排序结果：");
        System.out.println(Arrays.toString(BubbleSortArray));

        int[] SelectionSortArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
        SelectionSort(SelectionSortArray);
        System.out.print("选择排序算法排序结果：");
        System.out.println(Arrays.toString(SelectionSortArray));

        int[] QuickSortArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
        QuickSort(QuickSortArray,0,(QuickSortArray.length-1));
        System.out.print("快速排序算法排序结果：");
        System.out.println(Arrays.toString(QuickSortArray));

        System.out.print("任意输入长度不定的数组进行排序：");
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();//读入一行string
        String[] c=s.split(" ");//根据空格进行分割
        int[] array=new int[c.length];
        for(int i=0;i<c.length;i++) {
            array[i]=Integer.parseInt(c[i]);//将string转为int型
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
