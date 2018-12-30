package com.javapr;

public class intsort {
    public static void main(String args[]){
        int arrays[] = new int[]{7,13,29,3,0,-97,127,23,8};
        System.out.print("before sort:");
        System.out.println();
        for (int i = 0; i < arrays.length; i++)
            System.out.print(arrays[i] + " ");
        sort(arrays, arrays.length);
        System.out.print("\nafter sort:\n");
        for (int i = 0; i < arrays.length; i++)
            System.out.print(arrays[i] + " ");
        System.out.println();
    }
    public static void sort(int[] arr, int num){
        for (int i = 0; i < num; i++){
            int j = i + 1;
            for (; j < num; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
