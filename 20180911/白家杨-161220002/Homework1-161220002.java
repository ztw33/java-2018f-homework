package com.bjy.hello;

//import java.util.Arrays;
import java.util.Scanner;
public class Homework1 {
    public static void main(String[]args) {
        Homework1 sort;
        sort = new Homework1();
        sort.UndefineLength();
        sort.TenNumber();
    }
    /* 快排 */
    public void QuickSort(int[]data, int begin, int end)
    {
        if(begin >= end)
            return ;
        int value = data[begin];
        int first = begin;
        int last = end;
        while(first < last) {
            while (first < last && data[last] >= data[first])
                last--;
            data[first] = data[last];

            while (first < last && data[first] <= value)
                first++;
            data[last] = data[first];
        }
        data[first]=value;
        QuickSort(data, begin, first-1);
        QuickSort(data, first+1, end);
    }
    /* 输入十个数字 */
    public void TenNumber(){
        /*hello a = new hello();
        a.welcome();*/
        System.out.println("Enter 10 numbers to be sorted !");
        int []data = new int [10];
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 10; i++)
        {
            data[i] = scan.nextInt();
        }
        /* 快排 */
        QuickSort(data, 0, 9);
        //Arrays.sort(data);
        System.out.println("The result is:");
        for(int i = 0; i < 10; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
    /* 用于输入不定长数组 */
    public static void UndefineLength() {
        System.out.println("Enter numbers to be sorted !");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //按空格分割
        String[] str = s.split(" ");
        int[] data = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            data[i] = Integer.parseInt(str[i]);
        }
        /* 冒泡排序 */
        for (int i = 0; i < str.length; i++) {
            for (int j = 1; j < str.length - i; j++) {
                if(data[j - 1] > data[j])
                {
                    int tmp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = tmp;
                }
            }
        }
        //Arrays.sort(data);
        for (int i = 0; i < str.length; i++) {
            System.out.print(data[i] + " ");
        }

    }
}
