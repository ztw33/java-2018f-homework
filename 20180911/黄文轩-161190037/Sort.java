import java.util.Arrays;
public class Sort {
    public static void main(String[] args) {
        int[] array = {3,7,2,5,9,8,10,1,4,6};
        System.out.print("排序前：");
        showArray(array);
        BobbleSort(array);
        System.out.print("排序后：");
        showArray(array);
    }
    public static void BobbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void showArray(int[] array){
        for(int i:array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
