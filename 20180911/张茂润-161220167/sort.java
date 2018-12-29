public class sort {
    public static void main(String[] args ) {
        int array[] = {10, 8, 2, 3, 9, 7, 1, 2};
        int len = array.length;
        for(int i = 0; i < len; i++)
        {
            int min = array[i];
            int minplace = i;
            for(int j = i; j < len; j++)
            {
                if(array[j] < min)
                {
                    min = array[j];
                    minplace = j;
                }
            }
            int tmp = array[i];
            array[i] = min;
            array[minplace] = tmp;
        }
        for(int i = 0; i < len; i++)
            System.out.println(array[i] + " ");
    }
}
