public class Sort {
    public static void SimpleSort(int array[]) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++)
            for (int j = array.length - 1; j > i; j--)
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
    }

    public static void main(String[] args){
        int[] array={20,4,324,53,2342,32,55,66};
        SimpleSort(array);
        System.out.println("排序结果：" );
        for(int i=0;i<array.length;i++)
        System.out.print(array[i]+" ");
    }
}