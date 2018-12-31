public class Main {
    public static void main(String[] args) {
        int[] array = {45, 50, 3, 4, 46, 88, 65, 93, 36, 22, 34, 78, 76, 79,
                16, 35, 48, 81, 87, 15, 49, 63, 30, 96, 10, 94, 53};
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
        for(int i = 0; i < array.length - 1; ++i)
            for(int j = 0; j < i + 1; ++j) {
                if (array[i + 1] < array[j]) {
                    int temp = array[i + 1];
                    for(int k = i; k >= j; --k)
                        array[k + 1] = array[k];
                    array[j] = temp;
                }
            }
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }
}