package com.company;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int[] Array = new int[]{9, 6, 3, 8, 5, 2, 7, 4, 1};
        for (int i = 0; i < Array.length; i++) {
            for (int j = i + 1; j < Array.length; j++) {
                if (Array[i] > Array[j]) {
                    int temp = Array[j];
                    Array[j] = Array[i];
                    Array[i] = temp;
                }
            }
        }
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i]);
        }
    }
}