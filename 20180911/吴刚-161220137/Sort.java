import java.util.Arrays;

public class Sort {

    private void sort(int[] data){
        this.quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int begin, int end){
        if(begin < end){
            int index = returnIndex(data, begin, end);
            quickSort(data, begin, index - 1);
            quickSort(data, index + 1, end);
        }
    }

    private int returnIndex(int[] data, int begin, int end){
        int compareNum = data[begin];
        int returnIndex = begin;
        for(int i = begin + 1; i <= end; i++){
            if(data[i] < compareNum){
                returnIndex++;
                int temp = data[returnIndex];
                data[returnIndex] = data[i];
                data[i] = temp;
            }
        }
        int temp = data[returnIndex];
        data[returnIndex] = data[begin];
        data[begin] = temp;
        return returnIndex;
    }

    public static void main(String[] args){
        int[] a = new int[]{5,4,2,3,10};
        Sort sort = new Sort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
