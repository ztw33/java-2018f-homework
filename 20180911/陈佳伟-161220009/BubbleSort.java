package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];
        for(int i = 0; i < number; i++){
            array[i] = scanner.nextInt();
        }
        scanner.close();
        for(int i = 0; i < number; i++){
            for(int j = number-1; j > i; j--){
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
