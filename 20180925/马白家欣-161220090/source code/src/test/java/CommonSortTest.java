import common.CommonSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class CommonSortTest {

    public final int RANDOM_TEST_TIMES = 100;
    public final int ARRAY_MAX_SIZE = 10000;
    public final int ARRAY_NUMBER_RANGE = (1 << 31) - 1;

    @Test
    public void commonSortTest() {
        Random rand = new Random();
        for (int testNumber = 0; testNumber < RANDOM_TEST_TIMES; testNumber++) {

            int[] arrayToBeSorted = new int[ARRAY_MAX_SIZE];
            int[] standardSortedArray = new int[arrayToBeSorted.length];
            for (int i = 0; i < arrayToBeSorted.length; i++) {
                arrayToBeSorted[i] = rand.nextInt(ARRAY_NUMBER_RANGE);
                standardSortedArray[i] = arrayToBeSorted[i];
            }

            Arrays.sort(standardSortedArray);
            CommonSort.sort(arrayToBeSorted);

            assertArrayEquals(arrayToBeSorted, standardSortedArray);
        }


    }
}
