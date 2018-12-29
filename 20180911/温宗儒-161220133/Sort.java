import java.util.Arrays;
import java.util.Scanner;


public class Sort {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组的长度:");
        int length  = scanner.nextInt();
        while (length<=0){
            System.out.println("长度输入错误，请重新输入(长度大于0):");
            length = scanner.nextInt();
        }
        int[] array = new int[length];
        System.out.println("依次输入数组的各元素:");
        for(int i=0;i<length;i++) { array[i] = scanner.nextInt(); }
        scanner.close();

        quickSort(array,0,array.length-1);
        System.out.println("排序后的数组为:");
        System.out.println(Arrays.toString(array));

    }

    private static void quickSort(int[] array, int low, int high){
        int i=low,j=high,pivot;
        if(low > high) return;
        pivot = array[i];

        while (i<j){
            while (i<j && array[j] >= pivot) j--;
            if(i<j) array[i++] = array[j];
            while (i<j && array[i] < pivot) i++;
            if(i<j) array[j--] = array[i];
        }

        array[i] = pivot;
        quickSort(array,low,i-1);
        quickSort(array,i+1,high);
    }

}
