public class SortInteger {

    public static void main(String[] args){

        //a given Integer array
        int[] array = {3,1,4,2,5,7,8,6,0,6};

        System.out.println("unsorted:");
        print(array);
        sort(array);
        System.out.println("sorted:");
        print(array);

    }

    static void sort(int[] array){
        int n = array.length;
        // bubble sort algorithm
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1-i; j++){
                if(array[j] > array[j+1]){
                    int t  = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

    static void print(int[] array){
        for(int a:array) {
            System.out.print(a);
            System.out.print("\t");
        }
        System.out.println();
    }
}
