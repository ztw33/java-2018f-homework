//package com.company;

public class sort {
    public static void main(String[] args){
        int[] array={3,2,5,1,4};
        int temp=0;
        for(int i=0;i<array.length-1;i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for(int i=0;i<array.length;i++)
             System.out.print(array[i]+" ");
    }
}
