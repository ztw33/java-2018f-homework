package calabashBrothers;

import java.util.Arrays;
import java.util.Random;

/**
 * @ Author     ：Young
 * @ Description：测试代码,用于测试两个排序算法的正确性
 */
public class Test {
    private int[] arrayTest;
    private int arraySize;
    private Random rand;

    public Test() {
        rand = new Random();
        this.arraySize = rand.nextInt(200);
        arrayTest = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrayTest[i] = rand.nextInt(100) + 10;
        }
    }

    private void swap(int i, int j) {
        int temp = arrayTest[i];
        arrayTest[i] = arrayTest[j];
        arrayTest[j] = temp;
    }

    private boolean cmp(int i, int j) {
        return arrayTest[i] < arrayTest[j];
    }

    private void setArrayRandom() {
        int randTimes = rand.nextInt(50)+20;
        int m;
        int n;
        for (int i = 0; i < randTimes; i++) {
            m = rand.nextInt(arraySize);
            n = rand.nextInt(arraySize);
            swap(m,n);
        }
    }

    public boolean sortTest(Sorter sorter){
        int testTimes=rand.nextInt(20);
        boolean rightFlag = true;

        for (int i = 0; i < testTimes; i++) {
            setArrayRandom();
            int[] standardArray = arrayTest.clone();
            sorter.sort(arraySize);
            Arrays.sort(standardArray);
            for (int j = 0; j <arraySize ; j++) {
                if(arrayTest[j] != standardArray[j]){
                    rightFlag = false;
                    break;
                }
            }
        }
        return rightFlag;
    }

    public void bubbleTest() {
        BubbleSorter sorter = new BubbleSorter() {
            @Override
            void swapWithReport(int i, int j) {
                swap(i, j);
            }

            @Override
            boolean compareSmaller(int i, int j) {
                return cmp(i, j);
            }
        };

        boolean bubbleFlag = sortTest(sorter);
        if(bubbleFlag==true){
            System.out.println("function bubbleSort tests successfully.");
        }else{
            System.out.println("function bubbleSort tests failed.");
            System.exit(-1);
        }
    }

    public void binaryTest() {
        BinarySorter sorter = new BinarySorter() {
            @Override
            void swapWithReport(int i, int j) {
                swap(i, j);
            }

            @Override
            boolean compareSmaller(int i, int j) {
                return cmp(i, j);
            }
        };

        boolean binaryFlag = sortTest(sorter);
        if(binaryFlag==true){
            System.out.println("function binarySort tests successfully.");
        }else{
            System.out.println("function binarySort tests failed.");
            System.exit(-1);
        }
    }

}
