public class Sort{
    // 快速排序找spilit point
    private static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++){
            if(array[j] < pivot){
                i = i + 1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i + 1;
    }
    // 快速排序
    private static void quickSort(int[] array, int start, int end){
        if(start < end){
            int spilitPoint = partition(array, start, end);
            quickSort(array, start, spilitPoint-1);
            quickSort(array, spilitPoint+1, end);
        }
    }
    // 打印数组，空格分隔，结尾换行
    private static void print(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.print('\n');
    }
    public static void main(String[] args) {
        int[] numbers = {3,12,4,5,10,2,11,1,15,8,13,9,0,7,14,6};
        quickSort(numbers,0,numbers.length-1);
        print(numbers);
    }
}
