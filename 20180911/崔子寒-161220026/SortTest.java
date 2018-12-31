import java.util.*;

public class SortTest {
    /*Swap the position of two elements*/
    private  static void swap(Integer[] Array, int index1, int index2){
        Integer temp=Array[index1];
        Array[index1]=Array[index2];
        Array[index2]=temp;
    }
    /*
    Divide the array int two parts
    elements in one part are smaller than pivot
    elements in the other are larger than pivot
    */
    private static int partition(Integer[] Array, int first, int last){
        int splitPoint=first;
        int pivot=Array[first];
        for(int i=first+1;i<=last;i++){
            if(pivot>Array[i]){
                splitPoint++;
                if(i!=splitPoint){
                    swap(Array,i,splitPoint);
                }
            }
        }
        swap(Array,first,splitPoint);
        return splitPoint;
    }
    /*qucik sort*/
    /*Continuous recursion until the scale is small enough*/
    public static void quickSort(Integer[] Array, int first, int last){
        if(first < last) {
            int splitPoint = partition(Array, first, last);
            quickSort(Array, first, splitPoint);
            quickSort(Array, splitPoint+1, last);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        /*Vector as input buffer1*/
        Vector<Integer>buffer=new Vector<>();
        System.out.println("Input the array(end with a non-integer, e.g '#') and press Enter:");
        while(sc.hasNextInt()){
            buffer.add(sc.nextInt());
        }
        Integer array[]=new Integer[buffer.size()];
        buffer.copyInto(array);
        quickSort(array,0,array.length-1);
        for(int i=0;i<array.length;i++){
            //System.out.print(""+array.elementAt(i)+" ");
            System.out.print(""+array[i]+" ");
        }
    }
}
