package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int []Array={9,5,18,19,20,13,4,6,3,11,1,14,2,15,7,12,16,8,16,10};
        System.out.print("给定一个整形数组：");
        System.out.print("\n");
        for(int i=0;i<Array.length;i++)System.out.print(Array[i]+" ");
        System.out.print("\n");
        for(int i=0;i<Array.length-1;i++)
            for(int j=0;j<Array.length-1-i;j++)
            {
                if(Array[j]>Array[j+1]) {
                    int temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
            }
        System.out.print("排序后的整形数组：\n");
        for(int i=0;i<Array.length;i++)System.out.print(Array[i]+" ");
        System.out.print("\n");

    }
}
