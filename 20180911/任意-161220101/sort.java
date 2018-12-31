//package com.company;

public class sort {
    public static void main(String[] args){

        int[] arr = {23,12,48,56,45};
        int temp = -1;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]>arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]+" ");
    }
}

