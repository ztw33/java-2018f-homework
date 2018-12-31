package com.company;

import java.util.Scanner;

public class sort {
    private int []array;
    private int length;
    public void initialize(int len, int[]in)
    {
        length=len;
        array=new int[length];
        for(int i=0;i<length;i++)
            array[i]=in[i];
    }
    public void bubble_sort()
    {
        for (int i = 0; i < length - 1; i++)
        {
            for (int j = 0; j < length - 1 - i; j++)
            {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    void print()
    {
        for(int i=0;i<length;i++)
        {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入数组长度");
        int length=sc.nextInt();
        int []in=new int[length];
        System.out.println("输入数组");
        for(int i=0;i<length;i++)
        {
            in[i]=sc.nextInt();
        }
        sort example=new sort();
        example.initialize(length, in);
        example.bubble_sort();
        example.print();
    }
}
