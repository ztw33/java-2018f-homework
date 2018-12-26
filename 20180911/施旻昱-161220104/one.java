package java_study;

public class one {
    public static void main(String[] args)
    {
        int[] array = {5,3,6,7,1};
        array = array_sort(array);
        show(array);
    }
    public static int[] array_sort(int[] array)
    {
        for(int i = 0; i < array.length - 1; i++)
            for(int j = i + 1; j < array.length; j++)
                if(array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
                return array;
    }
    public static void show(int[] array)
    {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
