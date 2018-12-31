public class Sort{
    public static void main(String[] args){
        int arrays[]=new int[]{121,878,346,3167,618};//an array of 5 numbers
        bubble(arrays);//sort it
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }

    }
        public static void bubble(int[] arr){//bubblesort
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }

                }
            }
        }
}