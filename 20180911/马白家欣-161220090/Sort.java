package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Sort {

    public final int RANDOM_TEST_TIMES = 100;
    public final int ARRAY_MAX_SIZE = 10000;
    public final int ARRAY_NUMBER_RANGE = (1 << 31) - 1;
    int[] arrayToBeSorted = new int[ARRAY_MAX_SIZE];

    public static void main(String[] args) {

        Sort sort = new Sort();

        int wrongCount = 0;

        for (int i = 0; i < sort.RANDOM_TEST_TIMES; i++) {
            wrongCount += sort.randomTest(i);
        }

        System.out.println(wrongCount + " wrong cases!");
    }

    public int randomTest(int testNumber) {
        Random rand = new Random();
        int[] standardSortedArray = new int[arrayToBeSorted.length];
        for (int i = 0; i < arrayToBeSorted.length; i++) {
            arrayToBeSorted[i] = rand.nextInt(ARRAY_NUMBER_RANGE);
            standardSortedArray[i] = arrayToBeSorted[i];
        }

        Arrays.sort(standardSortedArray);
        sortArray();

        int wrongCount = 0;

        if (Arrays.equals(arrayToBeSorted, standardSortedArray) == true) {
            //System.out.println("Right！");
        } else {
            System.out.println("Wrong！Test number is : " + testNumber);
            wrongCount++;
        }

        return wrongCount;
    }

    public void sortArray()
    {
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
