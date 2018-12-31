public class Sort {
    public static void main(String[] args){
        int array[] = {2,4,1,9,5,7,8,3,6};  //numbers to sort
        System.out.println("Before sort:");
        for (int i:array)
        {
            System.out.print(i);
            System.out.print(' ');
        }
        for (int i = 0; i < array.length; i++)  //use bubble sort
        {
            for (int j = 0; j < array.length-i-1; j++)
            {
                if (array[j] > array[j+1])
                {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("\nAfter sort:");
       for (int i:array)
       {
           System.out.print(i);
           System.out.print(' ');
       }
    }
}
