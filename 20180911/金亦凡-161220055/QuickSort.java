package com.example.quicksort;

import java.util.Scanner;

public class QuickSort {
    public static int partition(int[] list, int p, int r) {
        int pivot = list[r];
        int i = p - 1;
        for(int j = p; j < r; j++) {
            if(list[j] < pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        int temp = list[r];
        list[r] = list[i + 1];
        list[i + 1] = temp;
        return i + 1;
    }

    public static void qs(int[] list, int p, int r) {
        if(p < r) {
            int q = partition(list, p, r);
            qs(list, p, q - 1);
            qs(list, q + 1, r);
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入数组大小：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("请输入" + n + "个数字：");
        int[] list = new int[n];
        for(int i = 0; i < n; i++)
            list[i] = input.nextInt();
        qs(list, 0, n - 1);
        for(int i = 0; i < n; i++)
            System.out.print(list[i] + " ");
    }
}
