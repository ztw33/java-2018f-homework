public class BubbleSort{

    public static void main(String[] args){
        int[] arr = new int[]{7,4,2,3,6};
        for(int a: arraySort(arr)){
            System.out.print(a+ " ");
        }
    }

    public static int[] arraySort(int[] arr){
        for(int i=0; i< arr.length-1; i++){
            for(int j=0; j< arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}