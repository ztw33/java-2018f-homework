package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * create by: Young
     * description: 冒泡排序法
     */
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * create by: Young
     * description: 用Java Array的sort方法对排序进行测试
     */
    private static void bubbleSortTest() {
        Random rand = new Random();

        //随机生成一个数组
        int arrayTestSize = rand.nextInt(200);
        int[] arrayTest = new int[arrayTestSize];
        for (int i = 0; i < arrayTestSize; i++) {
            arrayTest[i] = rand.nextInt(100);
        }
        //对随机生成的数组进行拷贝，并用Arrays.sort()方法进行排序测试
        int[] standardArray = arrayTest.clone();
        bubbleSort(arrayTest);
        Arrays.sort(standardArray);

        boolean rightFlag = true;

        //进行测试
        for (int i = 0; i < arrayTestSize; i++) {
            if(arrayTest[i] != standardArray[i]){
                rightFlag = false;
                break;
            }
        }

        if(rightFlag==true){
            System.out.println("function bubbleSort tests successfully.");
        }else{
            System.out.println("function bubbleSort tests failed.");
            System.exit(-1);
        }
    }

    /**
     * create by: Young
     * description: 对输入的一个数组排序
     */
    public static void main(String[] args) {

        bubbleSortTest();//先对bubbleSort方法进行测试

        Scanner in = new Scanner(System.in);

        int arraySize;
        System.out.println("Please input the size of the array :");
        arraySize = in.nextInt();
        int[] array = new int[arraySize];

        System.out.println("Please input " + arraySize + " integer numbers :");
        for (int i = 0; i < arraySize; i++) {
            array[i] = in.nextInt();
        }

        bubbleSort(array);

        System.out.println("After sorting,the array is :");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i] + " ");
        }

        in.close();
    }
}
