package common;

public class CommonSort {

    public static void sort(int[] arrayToBeSorted) {
        //insert sort
        for(int i = 1; i < arrayToBeSorted.length; i++)
        {
            for(int j = i - 1; j >= 0; j--)
            {
                if(arrayToBeSorted[j + 1] < arrayToBeSorted[j])
                {
                    int temp = arrayToBeSorted[j + 1];
                    arrayToBeSorted[j + 1] = arrayToBeSorted[j];
                    arrayToBeSorted[j] = temp;
                }
            }
        }
    }
}
