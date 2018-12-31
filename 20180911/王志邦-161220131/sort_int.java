public class sort_int {
    private static int array[] = new int[]{10, 3, 7, 6, 5, 2, 8, 9, 1, 4};
    private static void print(int array[]){
        for(int i = 0; i < 10; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    private static void sort(int array[]){
        for(int i = 0; i < 10; i++){
            for(int j = i+1; j < 10; ++j)
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
        }
    }
    public static void main(String[] args){
        sort(array);
        print(array);
    }
}
